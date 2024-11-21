package org.mikan.altairkit.api.gui.v1_20;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.InventoryView;
import org.mikan.altairkit.api.gui.Data;

public class InventoryCloseEventListener implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e){


        Player player = (Player) e.getPlayer();

        if (!Data.GUIMap.containsKey(player)) return;

        InventoryView view = e.getView();
        String title = view.getTitle();

        if (title.equals(Data.GUIMap.get(player)))
            Data.GUIMap.remove(player);
    }

}
