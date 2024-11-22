package engine.core.graphics;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    Graphics2D g2d;

    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D) g;
    }

    public Graphics2D getG2d() {
        return g2d;
    }
}