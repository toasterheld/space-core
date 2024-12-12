package engine.io.graphics;

import engine.util.Vector2D;

import javax.swing.*;
import java.awt.*;

/**
 * A custom JPanel that is used for rendering graphics. This class is responsible for managing the drawing surface
 * and handling the rendering process of the content in the game or application.
 */
public class Panel extends JPanel {

    Graphics2D g2d;  // Graphics2D object used for drawing

    /**
     * Constructor to create a new panel with the specified size.
     * Sets the preferred size for the panel and prepares it for receiving input events.
     *
     * @param size the size of the panel (as a Vector2D representing width and height)
     */
    public Panel(Vector2D size) {
        setPreferredSize(new Dimension((int) size.getX(), (int) size.getY()));

        // Make the panel focusable to capture input events
        setFocusable(true);
        requestFocusInWindow();
    }

    /**
     * This method is called whenever the panel needs to be repainted.
     * It sets up the graphics context and renders the current image from the Renderer.
     *
     * @param g the Graphics object used for drawing
     */
    public void paint(Graphics g) {
        g2d = (Graphics2D) g;
        // Draw the buffered image to the screen at position (0,0)
        g2d.drawImage(Renderer.getBufferedImage(), 0, 0, null);
    }

    /**
     * Gets the Graphics2D object that is used to perform drawing operations on the panel.
     *
     * @return the Graphics2D object
     */
    public Graphics2D getG2d() {
        return g2d;
    }
}
