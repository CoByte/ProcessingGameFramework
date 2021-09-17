package lib.sprites;

import lib.core.Resource;
import main.Main;
import processing.core.PImage;
import processing.core.PVector;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * Enum for every sprite in the game! Sprites compromise both single images and animations, which will all be taken
 * care of by this enum. Adding a sprite is as easy as adding a variant with a given path ("resources/sprites/" is
 * implied). The sprite will be loaded as an animation or a single image based on whether the path points to a
 * directory or to a file. You can also add a number of constants, to make creation easier. To use a sprite, just call
 * create on the variant to get a new Sprite object.
 *
 * Sprites are resources, and must be loaded to be used. They can be loaded all at once, but will automatically load
 * themselves on creation.
 */
public enum Sprites implements Resource {
    PISS("piss planet.png", new PVector(100, 100));

    private static final String FULL_SPRITE_PATH = "resources/sprites/"; // For normal Java path stuff
    private static final String PARTIAL_SPRITE_PATH = "sprites/"; // For processing sprite loading

    private final String path;
    private final Integer framesBetween;

    private boolean loaded = false;

    private PImage[] images;
    private boolean isSingleFrame;
    private PVector size;

    /**
     * @param path the path to the sprite.
     * @param framesBetween the number of frames each image of an animation should last
     * @param size the size of the sprite
     */
    Sprites(String path, int framesBetween, PVector size) {
        this.path = path;
        this.framesBetween = framesBetween;
        this.size = size;
    }

    /**
     * size defaults to the size of the image
     * @param path the path to the sprite
     * @param framesBetween the number of frames each image of an animation should last
     */
    Sprites(String path, int framesBetween) {
        this(path, framesBetween, null);
    }

    /**
     * framesBetween defaults to 1
     * @param path the path to the sprite.
     * @param size the size of the sprite
     */
    Sprites(String path, PVector size) {
        this(path, 1, size);
    }

    /**
     * framesBetween defaults to 1
     * size defaults to the size of the image
     * @param path the path to the sprite.
     */
    Sprites(String path) {
        this(path, 1);
    }

    /**
     * Loads the sprite image (Requires Main.p to be initialized)
     */
    public void load() {
        loaded = true;
        File imageFile = new File(FULL_SPRITE_PATH + path);

        System.out.println(imageFile.isFile());

        // Detects if the path is to a single image file, or to a directory
        if (imageFile.isFile()) {
            isSingleFrame = true;
            images = new PImage[] {Main.p.loadImage(PARTIAL_SPRITE_PATH + path)};
        } else {
            isSingleFrame = false;
            images = getImages(path);
        }

        if (size == null) size = new PVector(images[0].width, images[0].height);
    }

    private PImage[] getImages(String path) {
        File directory = new File(FULL_SPRITE_PATH + path);
        return Arrays.stream(Objects.requireNonNull(directory.list()))
                .map(name -> Main.p.loadImage(PARTIAL_SPRITE_PATH + path + "/" + name))
                .toArray(PImage[]::new);
    }

    /**
     * Creates a new sprite
     * @param framesBetween the number of frames each image of an animation should last
     * @param size the size of the sprite
     * @param looping whether the animation should loop
     * @return the newly generated sprite
     */
    public Sprite create(int framesBetween, boolean looping, PVector size) {
        if (!loaded) load();
        if (isSingleFrame) return new BasicSprite(images[0], size);
        else return new AnimatedSprite(images, framesBetween, looping, size);
    }

    /**
     * Creates a new sprite. Size will be set to default
     * @param framesBetween the number of frames each image of an animation should last
     * @param looping whether the animation should loop
     * @return the newly generated sprite
     */
    public Sprite create(int framesBetween, boolean looping) {
        return create(framesBetween, looping, size);
    }

    /**
     * Creates a new sprite. Size and looping will be set to default
     * @param framesBetween the number of frames each image of an animation should last
     * @return the newly generated sprite
     */
    public Sprite create(int framesBetween) {
        return create(framesBetween, true);
    }

    /**
     * Creates a new sprite. FramesBetween and size will be set to default
     * @param looping whether the animation should loop
     * @return the newly generated sprite
     */
    public Sprite create(boolean looping) {
        return create(framesBetween, looping);
    }

    /**
     * Creates a new sprite with all default parameters
     * @return the newly generated sprite
     */
    public Sprite create() {
        return create(framesBetween, true);
    }
}
