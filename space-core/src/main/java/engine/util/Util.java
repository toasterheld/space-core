package engine.util;

import javafx.scene.media.Media;
import engine.util.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * A utility class containing global methods that can be used throughout the project for various tasks,
 * such as image manipulation, media loading, value remapping, and more.
 */
public class Util {

    /**
     * Loads and returns a BufferedImage from the specified path.
     * If the image cannot be found, a default missing image is returned.
     *
     * @param path The relative path to the image (e.g., "/images/image.png")
     * @return The BufferedImage loaded from the specified path, or the missing image if not found
     */
    public static BufferedImage getBufferedImage(String path) {
        if(Util.class.getResource(path) == null && path != "/textures/missing.png"){
            return getBufferedImage("/textures/missing.png");
        }
        // get the image icon
        ImageIcon icon = new ImageIcon(Util.class.getResource(path));
        Image img = icon.getImage();
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // create a new image
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }

    /**
     * Rotates a given image by the specified angle in radians.
     *
     * @param img The image to rotate
     * @param radians The angle in radians to rotate the image
     * @return A new BufferedImage containing the rotated image
     */
    public static BufferedImage rotateImage(BufferedImage img, double radians) {
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));
        int w = img.getWidth();
        int h = img.getHeight();
        int newWidth = (int)Math.floor(w*cos+h*sin);
        int newHeight = (int)Math.floor(h*cos+w*sin);

        BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth-w)/2, (newHeight-h)/2);
        at.rotate(radians, w/2, h/2);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        return rotated;
    }

    /**
     * Converts an Image to a BufferedImage.
     *
     * @param img The Image to convert
     * @return The corresponding BufferedImage
     */
    public static BufferedImage imageToBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image onto the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    /**
     * Remaps a value from one range to another.
     * For example, remap(2, 0, 10, 0, 100) = 20.
     *
     * @param value The value to remap
     * @param low1 The lower bound of the original range
     * @param high1 The upper bound of the original range
     * @param low2 The lower bound of the target range
     * @param high2 The upper bound of the target range
     * @return The remapped value in the target range
     */
    public static double remap(double value, double low1, double high1, double low2, double high2) {
        return low2 + (value - low1) * (high2 - low2) / (high1 - low1);
    }

    /**
     * Loads and returns a Media object from the specified path.
     *
     * @param path The relative path to the media file (e.g., "/sounds/sound.mp3")
     * @return The Media object loaded from the specified path
     */
    public static Media getMedia(String path) {
        return new Media(Util.class.getResource(path).toString());
    }

    /**
     * Checks if a value is between two other values, inclusive.
     *
     * @param value The value to check
     * @param low The lower bound of the range
     * @param high The upper bound of the range
     * @return True if the value is between the low and high values, inclusive
     */
    public static boolean isBetween(double value, double low, double high) {
        return value >= low && value <= high;
    }

    /**
     * Checks if a Vector2D value is between two other Vector2D values, inclusive.
     *
     * @param value The Vector2D value to check
     * @param low The lower bound of the range (as a Vector2D)
     * @param high The upper bound of the range (as a Vector2D)
     * @return True if the Vector2D value is between the low and high bounds
     */
    public static boolean isVectorBetween(Vector2D value, Vector2D low, Vector2D high) {
        return isBetween(value.getX(), low.getX(), high.getX()) && isBetween(value.getY(), low.getY(), high.getY());
    }
}
