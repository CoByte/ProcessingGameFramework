package main.scenes;

/**
 * Basic interface for all scenes in the game. Examples of scenes include the pause menu, main menu, a level
 * select, a game level, etc. Basically anything that you might imagine the camera cuts into is a scene.
 */
public interface Scene {
    /**
     * Called on game startup to load needed resources. Should help to reduce the chance of weird null pointers when
     * things inevitably start getting hacked together.
     */
    public void Load();

    /**
     * Called when the scene is activated.
     */
    public void Activate();

    /**
     * Called every frame after the scene is activated. Should update and draw all entities in the scene, and do other
     * stuff as needed.
     */
    public void Update();

    /**
     * Called when the scene is deactivated.
     */
    public void Deactivate();
}
