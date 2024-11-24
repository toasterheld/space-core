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
        super.paint(g);
        g2d = (Graphics2D) g;
    }

    public Graphics2D getG2d() {
        return g2d;
    }
}