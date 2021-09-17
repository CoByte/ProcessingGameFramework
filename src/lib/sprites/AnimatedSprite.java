package lib.sprites;

import lib.misc.Transform;
import lib.misc.Utilities;
import processing.core.PImage;
import processing.core.PVector;

public class AnimatedSprite extends Sprite {

    private final PImage[] ANIMATION;
    private final int FRAMES_BETWEEN;
    private final boolean LOOPING;

    private int currentFrame = 0;
    private int timer = 0;
    private boolean ended = false;

    /**
     * @param animation a sequence of images
     * @param framesBetween the number of frames to wait before updating
     * @param looping whether the animation should loop
     */
    public AnimatedSprite(PImage[] animation, int framesBetween, boolean looping, PVector size) {
        ANIMATION = animation;
        FRAMES_BETWEEN = framesBetween;
        LOOPING = looping;
        this.size = size;
    }

    @Override
    public void update() {
        if (ended) return;

        timer++;
        if (timer > FRAMES_BETWEEN) {
            timer = 0;
            if (currentFrame + 1 == ANIMATION.length) {
                if (!LOOPING) ended = true;
                else currentFrame = 0;
            }
            else currentFrame++;
        }
    }

    @Override
    public void reset() {
        currentFrame = 0;
        timer = 0;
        ended = false;
    }

    @Override
    public void stepForward() {
        if (ended) return;
        timer = 0;
        if (currentFrame + 1 == ANIMATION.length) {
            if (LOOPING) currentFrame = 0;
        }
        else currentFrame++;
    }

    @Override
    public PImage getCurrentFrame() {
        return ANIMATION[currentFrame];
    }

    @Override
    public int getFrameCount() {
        return ANIMATION.length;
    }

    @Override
    public boolean hasEnded() {
        return ended;
    }
}
