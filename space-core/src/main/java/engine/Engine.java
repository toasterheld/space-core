package engine;

import engine.scene.Scene;
import engine.scene.SceneManager;
import engine.io.graphics.Renderer;
import engine.util.Time;
import engine.util.Vector2D;
import engine.io.graphics.Frame;
import engine.io.graphics.Panel;
import space_core.example.ExampleMaster;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Engine implements ActionListener {

    private Timer thread;
    private Panel panel;

    private Scene startScene;


    public void init() {
        createWindow();

      
        Renderer.init(panel);  
      
        SceneManager.init();

        startScene = new ExampleMaster();
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
        Vector2D size = new Vector2D(800, 600);

        Frame frame = new Frame("Engine", size);
        panel = new Panel(size);

        frame.addPanel(panel);
    }
}
