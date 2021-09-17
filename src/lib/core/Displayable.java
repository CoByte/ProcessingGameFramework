package lib.core;

// TODO - add link to tile once I've made it

/**
 * Interface to represent a displayable entity. Examples include the player, enemies, Tile, etc.
 * Often but not always comes alongside {@link Updatable}
 *
 * Notably, Displayable things are expected to know their own position. Ergo, sprites are not displayable.
 */
public interface Displayable {
    /**
     * Display method. Should be called every frame.
     * If {@link Updatable} is also implemented, this should be called after update
     */
    public void display();
}
