package me.redstonenotplaced.randompotioneffects.task;

import me.redstonenotplaced.randompotioneffects.manager.ChallengeManager;
import me.redstonenotplaced.randompotioneffects.state.ChallengeState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

/**
 * A class that is responsible for giving the players random potion effects every 30 seconds.
 *
 * @author RedstoneNotPlaced
 */
public final class PotionTask implements Runnable {
    private final ChallengeManager manager;
    private final PotionEffectType[] types = PotionEffectType.values();

    public PotionTask(ChallengeManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        // If the current state of the challenge is disabled, then we will do nothing.
        if(manager.getState() == ChallengeState.DISABLED) return;

        // Loops through all the online players.
        for(Player player : Bukkit.getOnlinePlayers()) {
            final int randomIndex = new Random().nextInt(types.length);
            final int randomAmplifier = new Random().nextInt(5);

            // Gives the player the random potion effect for 20 seconds with a random amplifier ranging to 0 to 5.
            // We have to multiply the duration to 20 since it is calculated in ticks.
            player.addPotionEffect(new PotionEffect(types[randomIndex], 20*20, randomAmplifier));
        }
    }
}