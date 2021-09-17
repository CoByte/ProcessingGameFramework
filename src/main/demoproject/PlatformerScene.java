package main.demoproject;

import com.jogamp.newt.event.KeyEvent;
import lib.input.InputManager;
import lib.misc.Transform;
import lib.misc.Trigger;
import lib.scenes.BaseScene;
import lib.sprites.Sprite;
import lib.sprites.Sprites;

// TODO - delete and remove from gitignore
/**
 * This is a demo class for brain thinky times. If anyone is reading this, then I fucked up and forgot to remove it.
 */
public class PlatformerScene extends BaseScene {
    enum Actions {
        LEFT(KeyEvent.VK_LEFT),
        RIGHT(KeyEvent.VK_RIGHT),
        JUMP(KeyEvent.VK_SPACE);

        public final Trigger event;
        Actions(short keyCode) {
            event = InputManager.getInstance().getEvent(keyCode);
        }
        public boolean rising() { return event.rising(); }
        public boolean pressed() { return event.triggered(); }
        public boolean falling() { return event.falling(); }
    }

    private Sprite test;

    public PlatformerScene() {
    }

    @Override
    public void load() {
        test = Sprites.PISS.create();
    }

    @Override
    public void activate() {

    }

    @Override
    public void update() {

    }

    @Override
    public void display() {
        test.draw(new Transform(250, 250));
    }

    @Override
    public void deactivate() {

    }
}
