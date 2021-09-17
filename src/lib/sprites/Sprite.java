package lib.sprites;

import lib.misc.Transform;
import lib.core.Updatable;
import lib.misc.Utilities;
import processing.core.PImage;
import processing.core.PVector;

public abstract class Sprite implements Updatable {

    public PVector size;

    /**
     * Resets the sprite's animation, if it has one.
     */
    public void reset() {};

    /**
     * @return The number of frames that the sprite has.
     */
    public abstract int getFrameCount();

    /**
     * @return if the animation has ended. Will always be false for {@link BasicSprite} and looping sprites
     */
    public abstract boolean hasEnded();

    /**
     * Steps the animation forward one frame. Has no effect on {@link BasicSprite},
     * and the last frame of non-looping sprites.
     */
    public void stepForward() {};

    /**
     * @return the current frame of the sprite.
     */
    public abstract PImage getCurrentFrame();

    /**
     * Displays the sprite.
     * @param transform where to center the sprite, and how much to rotate it.
     */
    public void draw(Transform transform) {
        Utilities.drawPImage(transform, getCurrentFrame(), size);
    }
}
