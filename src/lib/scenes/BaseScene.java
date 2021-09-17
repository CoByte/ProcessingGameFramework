package lib.scenes;

import com.jogamp.newt.event.KeyEvent;
import lib.input.InputManager;
import lib.misc.Trigger;
import main.Main;
import processing.core.PApplet;

/**
 * Serves as a useful template for making other scenes. However, the Scene interface can be used if features of
 * this class are unhelpful or counterproductive.
 */
public abstract class BaseScene implements Scene {
    /**
     * Because enums can't inherit, we'll have to improvise. Copy-Paste this into scenes where it's needed, and replace
     * PLACEHOLDER_ACTION with relevant actions.
     * I've tried to reduce boilerplate to a minimum, but I'm not magic.
     */
    enum Action {
        PLACEHOLDER_ACTION(KeyEvent.VK_ESCAPE);

        public final Trigger event;
        Action(short keyCode) {
            event = InputManager.getInstance().getEvent(keyCode);
        }
        public boolean rising() { return event.rising(); }
        public boolean pressed() { return event.triggered(); }
        public boolean falling() { return event.falling(); }
    }

    protected PApplet p = Main.p;
    protected boolean frozen = false;

    @Override
    public void freeze() {
        frozen = true;
    }

    @Override
    public void unfreeze() {
        frozen = false;
    }

    @Override
    public boolean isFrozen() {
        return frozen;
    }
}
