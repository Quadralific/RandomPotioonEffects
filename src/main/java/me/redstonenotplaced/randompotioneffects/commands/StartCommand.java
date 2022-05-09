package me.redstonenotplaced.randompotioneffects.commands;

import me.redstonenotplaced.randompotioneffects.manager.ChallengeManager;
import me.redstonenotplaced.randompotioneffects.state.ChallengeState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * A command that starts the challenge.
 *
 * @author RedstoneNotPlaced.
 */
public final class StartCommand implements CommandExecutor, TabCompleter {
    private final ChallengeManager manager;

    public StartCommand(ChallengeManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // If the command sender is not a player, then we will do nothing.
        if(!(sender instanceof Player)) return true;

        // If the current state of the challenge is disabled, then we will enable the challenge.
        if(manager.getState() == ChallengeState.DISABLED) {
            // Enables the challenge.
            manager.setState(ChallengeState.ENABLED);
            // Broadcast a message.
            Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "THE CHALLENGE HAS NOW STARTED!!!");
        } else {
            // If the current status of the challenge is already enabled, then we will send the command sender a message.
            sender.sendMessage(ChatColor.RED + "The challenge has already started!!!");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        // Returns a new arraylist so there is no tab complete.
        return new ArrayList<>();
    }
}