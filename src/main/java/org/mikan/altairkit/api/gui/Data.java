package org.mikan.altairkit.api.gui;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Data {

    // the player with its inventory title
    public static Map<Player,String> GUIMap = new HashMap<>();

    // the actual gui with its title
    public static Map<String,AltairGUI> inventoryMap = new HashMap<>();

    public static boolean listeningToAltairGUIs;


    public static void addToMap(Player player,String title){
        if (!Data.GUIMap.containsKey(player)) Data.GUIMap.put(player,title);
        else Data.GUIMap.replace(player,title);
    }

    public static void addGUI(String title,AltairGUI gui){
        if (!inventoryMap.containsKey(title)) inventoryMap.put(title,gui);
        else inventoryMap.replace(title,gui);
    }

    public static void removeGUI(String title){
        if (!inventoryMap.containsKey(title))
            inventoryMap.remove(title);
    }
}
