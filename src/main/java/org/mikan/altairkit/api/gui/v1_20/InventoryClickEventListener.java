package org.mikan.altairkit.api.gui.v1_20;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.mikan.altairkit.api.gui.Data;

public class InventoryClickEventListener implements Listener {


    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){


        if (!(e.getWhoClicked() instanceof Player)) return;

        Player player = (Player) e.getWhoClicked();

        if (!Data.GUIMap.containsKey(player)) return;

        InventoryView view = e.getView();
        String title = view.getTitle();

        if (title.equals(Data.GUIMap.get(player)))
            e.setCancelled(true);
    }

}
