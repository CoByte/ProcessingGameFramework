package main;

import lib.input.InputManager;
import lib.scenes.SceneStack;
import lib.sprites.Sprites;
import main.demoproject.PlatformerScene;
import processing.core.PApplet;
import processing.core.PVector;

import java.awt.*;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class Main extends PApplet {

    /**
     * Global reference to the PApplet. This should make things more concise, as everything and their mother needs
     * access to the sketch, and this way it doesn't need to be passed around everywhere.
     */
    public static PApplet p;

    // Global constants
    public static final PVector SIZE = new PVector(500, 500);
    public static final String TITLE = "template";
    public static final int FRAMERATE = 60;
    public static final int DEFAULT_MODE = CENTER;
    public static final Color BACKGROUND_COLOR = new Color(0, 15, 45);

    private final SceneStack sceneStack = SceneStack.getInstance();
    private final InputManager inputManager = InputManager.getInstance();

    // Various stuff
    private final PlatformerScene platformerScene = new PlatformerScene();

    public Main() throws URISyntaxException {
        // Don't put anything above this line, it should be the very first thing to execute to avoid null pointers
        p = this;
    }

    @Override
    public void settings() {
        size((int) SIZE.x, (int) SIZE.y, P2D);
    }

    @Override
    public void setup() {
        frameRate(FRAMERATE);
        surface.setTitle(TITLE);
        imageMode(DEFAULT_MODE);

        // Loads all sprites
        for (Sprites sprite : Sprites.values()) {
            sprite.load();
        }

        platformerScene.load();
        sceneStack.push(platformerScene);
    }

    @Override
    public void draw() {
        background(BACKGROUND_COLOR.getRGB());
        sceneStack.run();
    }

    @Override
    public void keyPressed() {
        inputManager.testPresses((short) keyCode);
    }

    @Override
    public void keyReleased() {
        inputManager.testReleases((short) keyCode);
    }

    public static void main(String... args) {
        PApplet.main("main.Main", args);
    }
}
