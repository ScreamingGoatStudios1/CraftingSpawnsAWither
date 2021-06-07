package com.jake.craftingwither;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class CraftingListener implements Listener {
    @EventHandler
    public void onCraft(CraftItemEvent e) {
        if (CraftingWither.isStarted) {
            Player player = (Player) e.getWhoClicked();
            Location location = player.getLocation();

            Bukkit.getWorld("world").spawnEntity(location, EntityType.WITHER);
        }
    }
}
