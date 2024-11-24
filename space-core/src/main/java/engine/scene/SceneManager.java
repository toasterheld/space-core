package engine.scene;

public class SceneManager {

    private static Scene currentScene;
    private static Scene loadingScene;

    public static void init() {
        loadingScene = new LoadingScene();
    }

    public static void update() {
        currentScene.update();
    }

    public static void render() {
        currentScene.render();
    }

    public static void setScene(Scene scene) {
        if (currentScene != null)
            if (!currentScene.destroy())
                return;

        loadingScene.render();
        currentScene = scene;
        currentScene.init();
    }
}
