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
 * A command that ends the challenge.
 *
 * @author RedstoneNotPlaced.
 */
public final class EndCommand implements CommandExecutor, TabCompleter {
    private final ChallengeManager manager;

    public EndCommand(ChallengeManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // If the command sender is not a player, then we will do nothing.
        if(!(sender instanceof Player)) return true;

        // If the current state of the challenge is enabled, then we will disable the challenge.
        if(manager.getState() == ChallengeState.ENABLED) {
            // Disables the challenge.
            manager.setState(ChallengeState.DISABLED);
            // Broadcast a message.
            Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "THE CHALLENGE HAS NOW ENDED!!!");
            return true;
        } else {
            // If the current status of the challenge is already disabled, then we will send the command sender a message.
            sender.sendMessage(ChatColor.RED + "The challenge is already disabled!!!");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        // Returns a new arraylist so there is no tab complete.
        return new ArrayList<>();
    }
}