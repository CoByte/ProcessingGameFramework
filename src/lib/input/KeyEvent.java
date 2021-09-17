package lib.input;

import lib.misc.Trigger;

public class KeyEvent extends Trigger {

    public final short key;

    public KeyEvent(short key) {
        this.key = key;
    }

    public void testPress(short testKey) {
        if (testKey == key) activate();
    }

    public void testRelease(short testKey) {
        if (testKey == key) deactivate();
    }
}
