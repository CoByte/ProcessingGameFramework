package main.input;

import main.misc.Trigger;

import java.util.ArrayList;

/**
 * Handles both keyboard and mouse input. Uses a singleton pattern for safe global access
 */
public class InputManager {
    private static InputManager instance;
    public static InputManager getInstance() {
        if (instance == null) instance = new InputManager();
        return instance;
    }

    private final ArrayList<KeyEvent> keys = new ArrayList<>();

    /**
     * Updates all internal KeyEvents with the pressed key.
     * Should be called in the keyPressed() method in {@link main.Main}.
     * @param key the keycode of the pressed key. Use the keyCode variable.
     */
    public void testPresses(short key) {
        getEvent(key).testPress(key);
    }

    /**
     * Updates all internal KeyEvents with the released key.
     * Should be called in the keyReleased() method in {@link main.Main}.
     * @param key the keycode of the released key. Use the keyCode variable.
     */
    public void testReleases(short key) {
        getEvent(key).testRelease(key);
    }

    /**
     * Gets a KeyEvent for a given keyCode. If the keyEvent does not currently exist, it is added to keys
     * @param key the keyCode. Use {@link com.jogamp.newt.event.KeyEvent} constants or the processing keyCode variable.
     * @return a KeyEvent corresponding to the provided keyCode
     */
    public KeyEvent getEvent(short key) {
        for (KeyEvent event : keys) {
            if (event.key == key) return event;
        }

        KeyEvent event = new KeyEvent(key);
        keys.add(event);
        return event;
    }

    /**
     * @param key the keyCode. Use {@link com.jogamp.newt.event.KeyEvent} constants or the processing keyCode variable.
     * @return whether the key is currently being pressed
     */
    public boolean isPressed(short key) {
        return getEvent(key).triggered();
    }
}
