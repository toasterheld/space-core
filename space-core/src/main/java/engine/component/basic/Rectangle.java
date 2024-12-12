package engine.component.basic;

import engine.component.Component;
import engine.entity.Entity;
import engine.io.graphics.Renderer;
import engine.util.Vector2D;

import java.awt.*;

/**
 * Represents a rectangle component that can be attached to an entity.
 * This component allows rendering a rectangle on the screen with a specified size and color.
 */
public class Rectangle extends Component {

    private Vector2D size = new Vector2D(0, 0);
    private Color color = Color.BLACK;

    /**
     * Constructs a Rectangle component associated with the specified parent entity.
     * The rectangle is initialized with a default size and color.
     *
     * @param parent the parent entity to which this rectangle component belongs
     */
    public Rectangle(Entity parent) {
        super(parent);
    }

    /**
     * Renders the rectangle at the current position with the specified size and color.
     * The rendering is handled by the Renderer utility.
     */
    @Override
    public void render() {
        Renderer.drawRectangle(getPos(), size, color);
    }

    // Getter and Setter methods

    public void setSize(Vector2D size) {
        this.size = size;
    }

    public Vector2D getSize() {
        return size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
