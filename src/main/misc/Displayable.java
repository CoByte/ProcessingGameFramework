package main.misc;

// TODO - add link to tile once I've made it

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Interface to represent a displayable entity. Examples include the player, enemies, Tile, etc.
 * Often but not always comes alongside {@link Updatable}
 */
public interface Displayable {
    /**
     * Display method. Should be called every frame.
     * If {@link Updatable} is also implemented, this should be called after update
     */
    public void display();

    /**
     * @return the the size of the display bounding box, NOT the collision box.
     */
    public PVector getDisplaySize();
}
