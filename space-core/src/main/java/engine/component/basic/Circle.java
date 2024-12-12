package engine.component.basic;

import engine.component.Component;
import engine.entity.Entity;
import engine.io.graphics.Renderer;

/**
 * Represents a circle component that can be rendered on the screen.
 * This component is attached to an entity and has a configurable radius.
 */
public class Circle extends Component {

    private int radius = 0;

    /**
     * Constructs a Circle component associated with the specified parent entity.
     *
     * @param parent the parent entity to which this circle component belongs
     */
    public Circle(Entity parent) {
        super(parent);
    }

    /**
     * Renders the circle at the current position with the specified radius.
     * The rendering is handled by the Renderer utility.
     */
    @Override
    public void render() {
        Renderer.drawCircle(getPos(), radius);
    }

    // Getter and Setter methods

    public void getRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}
