package org.mikan.altairkit;


import com.google.gson.Gson;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.mikan.altairkit.api.commands.AltairCommand;
import org.mikan.altairkit.api.gui.Data;
import org.mikan.altairkit.api.gui.v1_20.InventoryClickEventListener;
import org.mikan.altairkit.api.gui.v1_20.InventoryCloseEventListener;
import org.mikan.altairkit.api.json.AltairGsonFactory;
import org.mikan.altairkit.api.json.JsonFile;
import org.mikan.altairkit.api.yml.ConfigManager;
import org.mikan.altairkit.utils.CmdMap;
import org.mikan.altairkit.utils.PlayerHead;

import java.io.IOException;
import java.util.UUID;


public final class AltairKit extends JavaPlugin {

    public static AltairKit getInstance() {
        return INSTANCE;
    }

    private static AltairKit INSTANCE;
    public  static  JsonFile file ;
    @Override
    public void onEnable() {
        // Testing only

        INSTANCE = this;

        enableGUIManager(this);

        ConfigManager manager = new ConfigManager(this);

        try {
            manager.load("saaas/feae/odkae/test.yml",getResource("test.yml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileConfiguration file = manager.get("saaas/feae/odkae/test.yml");
        file.getKeys(false).forEach(key -> Bukkit.getLogger()
                .warning("Key: " + key));

        file.set("lol",false);

        manager.save("saaas/feae/odkae/test.yml");

        Bukkit.getScheduler().runTaskLater(this,() -> {
            file.set("lol",true);
            manager.save("saaas/feae/odkae/test.yml");
        },20);



    }


    public static void enableGUIManager(JavaPlugin plugin){
        Data.listeningToAltairGUIs = true;
        Bukkit.getPluginManager().registerEvents(new InventoryClickEventListener(),plugin);
        Bukkit.getPluginManager().registerEvents(new InventoryCloseEventListener(),plugin);
    }

    public static void enableGUIManager(Plugin plugin){
        Data.listeningToAltairGUIs = true;
        Bukkit.getPluginManager().registerEvents(new InventoryClickEventListener(),plugin);
        Bukkit.getPluginManager().registerEvents(new InventoryCloseEventListener(),plugin);
    }


    public static void disableGUIManager(JavaPlugin plugin){
        Data.listeningToAltairGUIs = false;
        Bukkit.getPluginManager().disablePlugin(plugin);
        Bukkit.getPluginManager().enablePlugin(plugin);
    }


    public static void registerCommand(AltairCommand command){
        CmdMap.getCommandMap().register("", command);
    }

    public static ItemStack getPlayerHead(Player player){
        try {
            return new PlayerHead(player).getItem();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static ItemStack getPlayerHead(OfflinePlayer player){
        try {
            return new PlayerHead(player).getItem();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static ItemStack getPlayerHead(UUID uuid){
        try {
            return new PlayerHead(uuid).getItem();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Gson buildGson(){
        return AltairGsonFactory.createGson();
    }

    public static String colorize(String s){
        return ChatColor.translateAlternateColorCodes('&',s);
    }

}
