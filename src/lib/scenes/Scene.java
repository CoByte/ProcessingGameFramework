package lib.scenes;

import lib.core.Displayable;
import lib.core.Resource;
import lib.core.Updatable;

/**
 * Basic interface for all scenes in the game. Examples of scenes include the pause menu, main menu, a level
 * select, a game level, etc. Basically anything that you might imagine the camera cuts into is a scene.
 */
public interface Scene extends Updatable, Displayable, Resource {
    /**
     * Called when the scene is activated.
     */
    public void activate();

    /**
     * Called when the scene is deactivated.
     */
    public void deactivate();

    /**
     * Prevents the update method from executing.
     */
    public void freeze();

    /**
     * Allows the execute method to execute again after being frozen.
     */
    public void unfreeze();

    /**
     * @return whether the scene is frozen or not.
     */
    public boolean isFrozen();
}
