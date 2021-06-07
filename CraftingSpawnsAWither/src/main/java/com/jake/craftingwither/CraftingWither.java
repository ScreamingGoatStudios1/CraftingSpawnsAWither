package com.jake.craftingwither;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CraftingWither extends JavaPlugin {
    public static CraftingWither plugin;

    public static boolean isStarted = false;

    @Override
    public void onEnable() {
        getCommand("craftingwither").setExecutor(new StartCommand());
        Bukkit.getPluginManager().registerEvents(new CraftingListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
