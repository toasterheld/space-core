package engine.scene;

/**
 * The SceneManager is responsible for managing the transitions between different scenes
 * in the game. It handles setting the current scene, rendering, and updating scenes.
 */
public class SceneManager {

    // The currently active scene
    private static Scene currentScene;

    // The loading scene displayed during scene transitions
    private static Scene loadingScene;

    /**
     * Initializes the SceneManager by setting up the loading scene.
     * This should be called at the start of the game.
     */
    public static void init() {
        loadingScene = new LoadingScene();
    }

    /**
     * Updates the current scene by calling its update method.
     * This should be called every game loop cycle to ensure all entities and components
     * in the scene are updated.
     */
    public static void update() {
        currentScene.update();
    }

    /**
     * Renders the current scene by calling its render method.
     * This should be called every game loop cycle to draw all entities and components
     * of the current scene to the screen.
     */
    public static void render() {
        currentScene.render();
    }

    /**
     * Sets a new scene and transitions to it. If there is a currently active scene,
     * it is destroyed before switching to the new scene. A loading scene is rendered
     * during the transition.
     *
     * @param scene the new scene to set as the current scene
     */
    public static void setScene(Scene scene) {
        if (currentScene != null)
            if (!currentScene.destroy())
                return;

        // Render the loading scene while transitioning
        loadingScene.render();

        // Set the new scene and initialize it
        currentScene = scene;
        currentScene.init();
    }
}
