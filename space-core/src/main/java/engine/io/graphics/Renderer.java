package engine.io.graphics;

import engine.component.basic.camera.CameraManager;
import engine.util.Vector2D;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Vector;

import static engine.component.basic.camera.CameraManager.getActiveCamera;

/**
 * A utility class responsible for rendering images, text, shapes, and other graphical elements
 * onto the screen using a Graphics2D object. The rendering is based on the active camera's position
 * and other settings such as size and alignment.
 */
public class Renderer {

    private static Panel panel;  // Panel for rendering graphics
    private static Graphics2D g2d;  // Graphics2D context for drawing
    private static BufferedImage bufferedImage;  // BufferedImage to store the rendering content

    /**
     * Initializes the Renderer with the provided panel. This method sets up the buffered image
     * and the graphics context used for drawing.
     *
     * @param p the panel to render onto
     */
    public static void init(Panel p) {
        panel = p;
        bufferedImage = new BufferedImage(p.getWidth(), p.getHeight(), BufferedImage.TYPE_INT_ARGB);
        g2d = bufferedImage.createGraphics();
    }

    /**
     * Draws an image at the specified position. The image will be scaled to fit its size.
     *
     * @param image the image to be drawn
     * @param pos the position on the screen to draw the image
     */
    public static void drawImage(BufferedImage image, Vector2D pos){
        Vector2D size = new Vector2D(image.getWidth(), image.getHeight());
        Vector2D screenPos = pos.copy();

        // Adjust position based on the active camera
        screenPos = getActiveCamera().getScreenPos(screenPos);
        screenPos = screenPos.sub(new Vector2D(size.copy().div(2)));
        g2d.drawImage(image, (int) screenPos.getX(), (int)screenPos.getY(), null);
    }

    /**
     * Draws an image at the specified position and with the specified size.
     *
     * @param image the image to be drawn
     * @param pos the position on the screen to draw the image
     * @param size the size of the image
     */
    public static void drawImage(BufferedImage image, Vector2D pos, Vector2D size){

        if(size == null){
            size = new Vector2D(image.getWidth(), image.getHeight());
            Vector2D screenPos = pos.copy();

            screenPos = getActiveCamera().getScreenPos(screenPos);
            screenPos = screenPos.sub(new Vector2D(size.copy().div(2)));
            drawImage(image, screenPos);
            return;
        }
        Vector2D screenPos = pos.copy();

        screenPos = getActiveCamera().getScreenPos(screenPos);
        screenPos = screenPos.sub(new Vector2D(size.copy().div(2)));

        g2d.drawImage(image, (int) screenPos.getX(), (int)screenPos.getY(), (int)size.getX(), (int)size.getY(),null);
    }

    /**
     * Draws text at the specified position with the given font size, font family, and alignment.
     *
     * @param text the text to be drawn
     * @param pos the position to draw the text (top-left corner)
     * @param fontSize the size of the font
     * @param fontFamily the family of the font
     * @param alignment the alignment of the text (0 = left, 1 = center, 2 = right)
     */
    public static void drawText(String text, Vector2D pos, int fontSize, String fontFamily, int alignment) {
        pos = getActiveCamera().getScreenPos(pos);
        if (g2d == null) {
            System.err.println("Graphics2D context is not available!");
            return;
        }

        Font font = new Font(fontFamily, Font.PLAIN, fontSize);
        g2d.setFont(font);

        int x = (int) pos.getX();
        int y = (int) pos.getY();

        // Adjust text position based on alignment
        if (alignment == 1) {
            Rectangle2D bounds = g2d.getFontMetrics().getStringBounds(text, g2d);
            x -= (int) bounds.getWidth() / 2;
        } else if (alignment == 2) {
            Rectangle2D bounds = g2d.getFontMetrics().getStringBounds(text, g2d);
            x -= (int) bounds.getWidth();
        }

        g2d.drawString(text, x, y);
    }

    /**
     * Draws text at the specified position with the default font size (20), font family ("Arial"),
     * and left alignment.
     *
     * @param text the text to be drawn
     * @param pos the position to draw the text (top-left corner)
     */
    public static void drawText(String text, Vector2D pos) {
        drawText(text, pos, 20, "Arial", 0);
    }

    /**
     * Draws text at the specified position with the given font size and default font family ("Arial")
     * and left alignment.
     *
     * @param text the text to be drawn
     * @param pos the position to draw the text (top-left corner)
     * @param fontSize the size of the font
     */
    public static void drawText(String text, Vector2D pos, int fontSize) {
        drawText(text, pos, fontSize, "Arial", 0);
    }

    /**
     * Draws text at the specified position with the given font size and font family, and the default
     * left alignment.
     *
     * @param text the text to be drawn
     * @param pos the position to draw the text (top-left corner)
     * @param fontSize the size of the font
     * @param fontFamily the family of the font
     */
    public static void drawText(String text, Vector2D pos, int fontSize, String fontFamily) {
        drawText(text, pos, fontSize, fontFamily, 0);
    }

    /**
     * Draws text at the specified position with the given font size and alignment, and the default
     * font family ("Arial").
     *
     * @param text the text to be drawn
     * @param pos the position to draw the text (top-left corner)
     * @param fontSize the size of the font
     * @param alignment the alignment of the text (0 = left, 1 = center, 2 = right)
     */
    public static void drawText(String text, Vector2D pos, int fontSize, int alignment) {
        drawText(text, pos, fontSize, "Arial", alignment);
    }

    /**
     * Draws a rectangle at the specified position and size, with the given color.
     *
     * @param pos the position of the rectangle
     * @param size the size of the rectangle
     * @param color the color of the rectangle
     */
    public static void drawRectangle(Vector2D pos, Vector2D size, Color color){
        Vector2D screenPos = pos.copy();

        screenPos = getActiveCamera().getScreenPos(screenPos);
        screenPos = screenPos.sub(new Vector2D(size.copy().div(2)));

        g2d.setColor(color);
        g2d.drawRect((int) screenPos.getX(), (int) screenPos.getY(), (int) size.getX(), (int) size.getY());
    }

    /**
     * Draws a circle at the specified position with the given radius.
     *
     * @param pos the position of the circle
     * @param radius the radius of the circle
     */
    public static void drawCircle(Vector2D pos, int radius) {

        Vector2D screenPos = pos.copy();

        screenPos = getActiveCamera().getScreenPos(screenPos);
        screenPos = screenPos.sub(new Vector2D(radius / 2, radius / 2));

        g2d.drawOval((int) screenPos.getX() - radius, (int) screenPos.getY() - radius, 2 * radius, 2 * radius);
    }

    /**
     * Returns the buffered image where all graphics are drawn.
     *
     * @return the buffered image
     */
    public static BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    /**
     * Returns the size of the buffered image (width and height).
     *
     * @return the size of the buffered image as a Vector2D
     */
    public static Vector2D getBufferSize() {
        return new Vector2D(bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    /**
     * Clears the current image by filling it with a white color.
     */
    public static void clear(){
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    /**
     * Renders the buffered image to the panel by calling its repaint method.
     */
    public static void render() {
        panel.repaint();
    }
}
