package me.redstonenotplaced.randompotioneffects;

import me.redstonenotplaced.randompotioneffects.commands.EndCommand;
import me.redstonenotplaced.randompotioneffects.commands.StartCommand;
import me.redstonenotplaced.randompotioneffects.manager.ChallengeManager;
import me.redstonenotplaced.randompotioneffects.task.PotionTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The main class of RandomPotionEffects.
 *
 * @author RedstoneNotPlaced.
 */
public final class RandomPotionEffects extends JavaPlugin {
    private ChallengeManager manager;

    @Override
    public void onEnable() {
        this.manager = new ChallengeManager();
        getCommand("start").setExecutor(new StartCommand(manager));
        getCommand("end").setExecutor(new EndCommand(manager));
        Bukkit.getScheduler().runTaskTimer(this, new PotionTask(manager), 0L, 20*30);
    }

    @Override
    public void onDisable() {
       this.manager = null;
    }
}