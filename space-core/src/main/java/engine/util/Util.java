package engine.util;

import javafx.scene.media.Media;
import engine.util.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

// class with global methods which can be used in the whole project
public class Util {

    // get the buffered image using the path to it. f.e. "/images/image.png"
    public static BufferedImage getBufferedImage(String path) {
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

    // rotate the image by the given angle in radians
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

    // converts an Image to a BufferedImage
    public static BufferedImage imageToBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    // remap a value from one range to another. f.e. remap(2, 0, 10, 0, 100) = 20
    public static double remap(double value, double low1, double high1, double low2, double high2) {
        return low2 + (value - low1) * (high2 - low2) / (high1 - low1);
    }

    // get the media using the path to the media. f.e. "/sounds/sound.mp3"
    public static Media getMedia(String path) {
        return new Media(Util.class.getResource(path).toString());
    }

    // check if the value is between the two other values
    public static boolean isBetween(double value, double low, double high) {
        return value >= low && value <= high;
    }

    //
    public static boolean isVectorBetween(Vector2D value, Vector2D low, Vector2D high) {
        return isBetween(value.getX(), low.getX(), high.getX()) && isBetween(value.getY(), low.getY(), high.getY());
    }
}
