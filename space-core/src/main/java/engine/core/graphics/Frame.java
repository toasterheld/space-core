package engine.core.graphics;

import engine.util.Vector2D;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private JFrame frame;

    public Frame(String title, Vector2D size) {
        // set up window
        super(title);
        setSize((int) size.getX(), (int) size.getY());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 0, 0));
    }

    public void addPanel(Panel panel) {
        add(panel);
        pack();
        panel.requestFocusInWindow();
    }

    public JFrame getFrame() {
        return frame;
    }
}
