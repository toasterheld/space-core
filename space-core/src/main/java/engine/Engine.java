package engine;

import engine.save.ConfigManager;
import engine.scene.Scene;
import engine.scene.SceneManager;
import engine.io.graphics.Renderer;
import engine.util.Time;
import engine.util.Vector2D;
import engine.io.graphics.Frame;
import engine.io.graphics.Panel;
import space_core.example.ExampleMaster;
import com.google.gson.Gson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Engine class is responsible for initializing, running, and updating the game loop,
 * managing scenes, and rendering the game world. It integrates various components such as
 * configuration management, window creation, and scene management.
 */
public class Engine implements ActionListener {

    // Gson instance used for JSON parsing
    Gson gson = new Gson();

    // Timer instance used to run the game loop at a fixed frame rate
    private Timer thread;

    // Panel for rendering the game
    private Panel panel;

    // The starting scene for the game
    private Scene startScene;

    /**
     * Initializes the game engine by setting up configuration, window, rendering, and scene management.
     * This method should be called before starting the game loop.
     */
    public void init() {
        // Initialize the configuration manager
        ConfigManager.init();

        // Create the game window
        createWindow();

        // Initialize the Renderer with the panel for rendering
        Renderer.init(panel);

        // Initialize the SceneManager
        SceneManager.init();

        // Set the starting scene
        startScene = getStartScene();
        SceneManager.setScene(startScene);
    }

    /**
     * Starts the game loop, where the game will update and render at a fixed frame rate.
     * This method should be called to begin the game loop after initialization.
     */
    public void startGameLoop() {
        // Initialize the time system and start the game loop timer
        Time.init();
        thread = new Timer((int) (1000 / Time.getFPS()), this);
        thread.start();
    }

    /**
     * The actionPerformed method is called on each game loop tick. It updates the time, clears the screen,
     * updates the current scene, renders the scene, and updates the display.
     *
     * @param e The action event triggered by the timer
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Update the delta time
        Time.updateDeltaTime();

        // Clear the previous frame
        Renderer.clear();

        // Update the current scene
        SceneManager.update();

        // Render the current scene
        SceneManager.render();
        Renderer.render();
    }

    /**
     * Creates the game window based on the configuration settings.
     * The window's title and size are defined in the configuration file.
     */
    private void createWindow() {
        // Get the window size from the configuration
        Vector2D size = new Vector2D(
                Integer.parseInt(ConfigManager.getGameConfigValue("window.width")),
                Integer.parseInt(ConfigManager.getGameConfigValue("window.height"))
        );

        // Create the window frame and panel for rendering
        Frame frame = new Frame(ConfigManager.getGameConfigValue("window.title"), size);
        panel = new Panel(size);

        // Add the panel to the frame
        frame.addPanel(panel);
    }

    /**
     * Retrieves the starting scene class name from the configuration and instantiates it.
     * The scene class is expected to be defined in the configuration file.
     *
     * @return The instantiated starting scene
     */
    private Scene getStartScene() {
        try {
            // Load the class for the starting scene from the configuration
            Class<?> act = Class.forName(ConfigManager.getGameConfigValue("startScene"));
            return (Scene) act.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            // Handle exceptions related to scene instantiation
            e.printStackTrace();
        }
        return null;
    }
}
