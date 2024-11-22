package engine.io.graphics;

import java.awt.*;

public class Renderer {

    private static Panel panel;
    private static Graphics2D g2d;

    public static void init(Panel p) {
        panel = p;
    }

    public static void render() {
        panel.repaint();
        g2d = panel.getG2d();
    }
}
