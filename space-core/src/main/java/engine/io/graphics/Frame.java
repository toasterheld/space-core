package engine.io.graphics;

import engine.util.Vector2D;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private JFrame frame;

    public Frame(String title, Vector2D size) {
        // set up window
        super(title);
        System.out.println((int) size.getX() + " " + (int) size.getY());
        setSize((int) size.getX(), (int) size.getY());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 0, 0));
        setVisible(true);
    }

    public void addPanel(Panel panel) {
        add(panel);
        pack();
    }

    public JFrame getFrame() {
        return frame;
    }
}
