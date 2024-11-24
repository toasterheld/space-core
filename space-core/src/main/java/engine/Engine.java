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

public class Engine implements ActionListener {

    Gson gson = new Gson();

    private Timer thread;
    private Panel panel;

    private Scene startScene;


    public void init() {
        ConfigManager.init();

        createWindow();

      
        Renderer.init(panel);  
      
        SceneManager.init();

        startScene = getStartScene();
        SceneManager.setScene(startScene);
    }

    public void startGameLoop() {

        Time.init();
        thread = new Timer((int) (1000 / Time.getFPS()), this);
        thread.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // update
        Time.updateDeltaTime();

        Renderer.clear();

        SceneManager.update();
      
      
        // render
        SceneManager.render();
        Renderer.render();

        //System.out.println("Delta Time: " + Time.getDeltaTime() + " seconds | " + "Passed: " + Time.getPassedTime());
    }


    private void createWindow() {
        Vector2D size = new Vector2D(
                Integer.parseInt(ConfigManager.getGameConfigValue("window.width")),
                Integer.parseInt(ConfigManager.getGameConfigValue("window.height"))
        );

        Frame frame = new Frame(ConfigManager.getGameConfigValue("window.title"), size);
        Panel panel = new Panel(size);

        frame.addPanel(panel);
    }

    private Scene getStartScene() {
        try {
            Class<?> act = Class.forName(ConfigManager.getGameConfigValue("startScene"));
            return (Scene) act.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
