package lib.sprites;

import processing.core.PImage;
import processing.core.PVector;

/**
 * Represents a single image as a sprite
 */
public class BasicSprite extends Sprite {
    private final PImage IMAGE;

    public BasicSprite(PImage image, PVector size) {
        this.IMAGE = image;
        this.size = size;
    }

    /**
     * Does nothing for BasicSprites, as they have no animation
     */
    @Override
    public void update() {}

    @Override
    public PImage getCurrentFrame() {
        return IMAGE;
    }

    /**
     * @return 1, because technically there is 1 frame
     */
    @Override
    public int getFrameCount() {
        return 1;
    }

    /**
     * @return false, because there is no animation to end
     */
    @Override
    public boolean hasEnded() {
        return false;
    }
}
