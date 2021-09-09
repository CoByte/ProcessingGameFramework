package main;

import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

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

    public Main() {
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
    }

    @Override
    public void draw() {
    }

    @Override
    public void keyPressed() {
    }

    public static void main(String... args) {
        PApplet.main("main.Main", args);
    }
}
