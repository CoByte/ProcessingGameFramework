package lib.core;

// TODO - add link to timer once I've made it

import lib.core.Displayable;

/**
 * Interface to represent an updatable entity. Examples include the player, enemies, Timer, etc.
 * Often but not always comes alongside {@link Displayable}
 */
public interface Updatable {

    /**
     * Update method. Should be called every frame.
     * If {@link Displayable} is also implemented, this should be called before display
     */
    public void update();
}
