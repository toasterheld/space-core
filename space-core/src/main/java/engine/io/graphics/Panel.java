package engine.io.graphics;

import engine.util.Vector2D;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    Graphics2D g2d;

    public Panel(Vector2D size) {
        setPreferredSize(new Dimension((int) size.getX(), (int) size.getY()));

        setFocusable(true);
        requestFocusInWindow();
    }

    public void paint(Graphics g) {
        g2d = (Graphics2D) g;
        g2d.drawImage(Renderer.getBufferedImage(), 0,0,null);
    }

    public Graphics2D getG2d() {
        return g2d;
    }
}