package engine;

import engine.util.Time;
import engine.util.Vector2D;
import engine.graphics.Frame;
import engine.graphics.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Engine implements ActionListener {

    private Timer thread;


    public void init() {
        createWindow();
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


        // render
        System.out.println("Delta Time: " + Time.getDeltaTime() + " seconds | " + "Passed: " + Time.getPassedTime());
    }


    private void createWindow() {
        Frame frame = new Frame("Engine", new Vector2D(800, 600));
        Panel panel = new Panel();
        frame.addPanel(panel);
    }
}
