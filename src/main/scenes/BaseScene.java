package main.scenes;

import com.jogamp.newt.event.KeyEvent;
import main.input.InputManager;
import main.misc.Trigger;

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
    enum ActionTemplate {
        PLACEHOLDER_ACTION(KeyEvent.VK_ESCAPE);

        public final Trigger event;
        ActionTemplate(short keyCode) {
            event = InputManager.getInstance().getEvent(keyCode);
        }
        public boolean rising() { return event.rising(); }
        public boolean pressed() { return event.triggered(); }
        public boolean falling() { return event.falling(); }
    }

    /**
     * In order for this to work, early return from update when frozen is true. It can't be done with inheritance ;-;.
     */
    protected boolean frozen = false;

    public void freeze() { frozen = true; }
    public void unfreeze() { frozen = false; }
}
