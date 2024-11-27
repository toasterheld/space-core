package engine.io.graphics;

import engine.component.basic.camera.CameraManager;
import engine.util.Vector2D;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Vector;

import engine.component.basic.camera.CameraManager;

import static engine.component.basic.camera.CameraManager.getActiveCamera;

public class Renderer {

    private static Panel panel;
    private static Graphics2D g2d;
    private static BufferedImage bufferedImage;

    public static void init(Panel p) {
        panel = p;
        bufferedImage = new BufferedImage(p.getWidth(), p.getHeight(), BufferedImage.TYPE_INT_ARGB);
        g2d = bufferedImage.createGraphics();
    }


    public static void drawImage(BufferedImage image, Vector2D pos){
        pos = getActiveCamera().getScreenPos(pos);
        g2d.drawImage(image, (int) pos.getX(), (int)pos.getY(), null);
    }

    public static void drawImage(BufferedImage image, Vector2D pos, Vector2D size){
        pos = getActiveCamera().getScreenPos(pos);
        if(size == null){
            drawImage(image, pos);
            return;
        }
        g2d.drawImage(image, (int) pos.getX(), (int)pos.getY(), (int)size.getX(), (int)size.getY(),null);
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


    public static void drawRectangle(Vector2D pos, Vector2D size, Color color){
        pos = getActiveCamera().getScreenPos(pos);
        g2d.setColor(color);
        g2d.drawRect((int) pos.getX(), (int) pos.getY(), (int) size.getX(), (int) size.getY());
    }

    public static void drawCircle(Vector2D pos, int radius) {
        pos = getActiveCamera().getScreenPos(pos);
        g2d.drawOval((int) pos.getX() - radius, (int) pos.getY() - radius, 2 * radius, 2 * radius);
    }


    public static BufferedImage getBufferedImage() {
        return bufferedImage;
    }
    public static Vector2D getBufferSize() {
        return new Vector2D(bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    public static void clear(){
        g2d.setColor(Color.white);
        g2d.fillRect(0,0, bufferedImage.getWidth(), bufferedImage.getHeight());
    }



    public static void render() {

        panel.repaint();

        //g2d = panel.getG2d();
    }


}
