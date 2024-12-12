package engine.io.graphics;

import engine.util.Vector2D;
import engine.io.input.InputManager;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a graphical window (JFrame) that serves as the main container for rendering and user input.
 * It is responsible for managing the display size, input handling, and adding additional components like panels.
 */
public class Frame extends JFrame {
    private JFrame frame;  // The main JFrame object

    /**
     * Creates a new window with the specified title and size.
     * This initializes the window with basic properties like size, background color, and input handling.
     *
     * @param title the title of the window
     * @param size the size of the window (as a Vector2D representing width and height)
     */
    public Frame(String title, Vector2D size) {
        // set up window
        super(title);
        //System.out.println((int) size.getX() + " " + (int) size.getY());
        setSize((int) size.getX(), (int) size.getY());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 0, 0));
        setVisible(true);

        // Setting focusable for input handling
        this.setFocusable(true);

        // Adding key listener for handling user input
        InputManager keyListener = new InputManager();
        this.addKeyListener(keyListener);
    }

    /**
     * Adds a new panel to the window and resizes the window to fit the panel's components.
     *
     * @param panel the panel to be added to the window
     */
    public void addPanel(Panel panel) {
        add(panel);
        pack();
    }

    /**
     * Retrieves the main JFrame object associated with this window.
     *
     * @return the JFrame instance
     */
    public JFrame getFrame() {
        return frame;
    }
}
