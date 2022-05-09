package me.redstonenotplaced.randompotioneffects.manager;

import me.redstonenotplaced.randompotioneffects.state.ChallengeState;

/**
 * A class for managing the challenge.
 *
 * @author RedstoneNotPlaced
 */
public final class ChallengeManager {
    // The state is disabled on default.
    private ChallengeState state = ChallengeState.DISABLED;

    /**
     * Gets the current state of the challenge.
     *
     * @return The current state of the challenge.
     */
    public ChallengeState getState() {
        return this.state;
    }

    /**
     * Sets the state of the challenge.
     *
     * @param state The state to set.
     */
    public void setState(ChallengeState state) {
        // If the current state is the same as the state to set, then we will do nothing.
        if(state == this.state) return;

        this.state = state;
    }
}