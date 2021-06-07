package com.jake.craftingwither;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("craftingwither.toggle")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("start")) {
                        if (!CraftingWither.isStarted) {
                            CraftingWither.isStarted = true;
                            Bukkit.broadcastMessage(ChatColor.GRAY + "Minecraft, but crafting spawn a wither has " + ChatColor.GREEN + "begun" + ChatColor.GRAY + "!");
                        } else {
                            player.sendMessage(ChatColor.RED + "The challenge has already started!");
                        }
                    } else if (args[0].equalsIgnoreCase("stop")) {
                        if (CraftingWither.isStarted) {
                            CraftingWither.isStarted = false;
                            Bukkit.broadcastMessage(ChatColor.GRAY + "Minecraft, but crafting spawn a wither has " + ChatColor.RED + "ended" + ChatColor.GRAY + "!");
                        } else {
                            player.sendMessage(ChatColor.RED + "The challenge hasn't started yet!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "/craftingwither <start/stop>");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "/craftingwither <start/stop>");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Only players can use that command!");
        }

        return false;
    }
}
