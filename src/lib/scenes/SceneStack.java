package lib.scenes;

import java.util.ArrayList;

public class SceneStack {
    private static SceneStack instance;
    public static SceneStack getInstance() {
        if (instance == null) instance = new SceneStack();
        return instance;
    }

    private final ArrayList<Scene> scenes = new ArrayList<>();

    private SceneStack() {}

    /**
     * Updates the scene stack first in first out
     */
    public void run() {
        for (Scene scene : scenes) {
            if (!scene.isFrozen()) scene.update();
            scene.display();
        }
    }

    /**
     * Adds a scene to the top of the stack and activates it
     * @param scene the scene to add
     */
    public void push(Scene scene) {
        scene.activate();
        scenes.add(scene);
    }

    /**
     * Removes the scene at the top of the stack and deactivates it
     */
    public void pop() {
        scenes.remove(scenes.size() - 1).deactivate();
    }

    /**
     * Swaps the current top scene with a new scene
     * @param scene the scene to swap in
     */
    public void swap(Scene scene) {
        pop();
        push(scene);
    }

    /**
     * Gets the scene on the top of the stack, but does not remove it
     * @return the top scene
     */
    public Scene peak() {
        return scenes.get(scenes.size() - 1);
    }
}
