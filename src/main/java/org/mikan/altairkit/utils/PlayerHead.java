package org.mikan.altairkit.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class PlayerHead {

    private final ItemStack skullItem = new ItemStack(Material.PLAYER_HEAD);

    public PlayerHead(Player player) throws NoSuchFieldException, IllegalAccessException {

        SkullMeta meta = (SkullMeta) skullItem.getItemMeta();
        meta.setOwningPlayer(player);
        skullItem.setItemMeta(meta);
    }

    public PlayerHead(UUID playerUUID) throws NoSuchFieldException, IllegalAccessException {

        SkullMeta meta = (SkullMeta) skullItem.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(playerUUID));
        skullItem.setItemMeta(meta);
    }

    public PlayerHead(OfflinePlayer player) throws NoSuchFieldException, IllegalAccessException {

        SkullMeta meta = (SkullMeta) skullItem.getItemMeta();
        meta.setOwningPlayer(player);
        skullItem.setItemMeta(meta);
    }

    public ItemStack getItem() {
        return skullItem;
    }
}
