package engine.component;

import engine.entity.Entity;
import engine.util.Vector2D;

/**
 * Represents a base component that can be attached to an entity.
 * This class provides basic functionality for positioning and updating components.
 */
public class Component {

    private Vector2D pos;
    protected Vector2D offset;

    /**
     * Constructs a Component and associates it with the given parent entity.
     * The component is initialized with a default offset (0, 0) relative to the parent entity's position.
     *
     * @param parent the parent entity to which this component is attached
     */
    public Component(Entity parent) {
        offset = new Vector2D(0, 0);
        pos = parent.getPos().add(offset);
    }

    /**
     * Initializes the component. This method can be overridden in subclasses for custom initialization.
     */
    public void init() {
        // Custom initialization code can be added in subclasses
    }

    /**
     * Updates the component. This method can be overridden in subclasses for custom update logic.
     */
    public void update() {
        // Custom update code can be added in subclasses
    }

    /**
     * Renders the component. This method can be overridden in subclasses for custom rendering logic.
     */
    public void render() {
        // Custom rendering code can be added in subclasses
    }

    // Getter and Setter methods

    /**
     * Returns the position of the component.
     *
     * @return the position of the component
     */
    protected Vector2D getPos() {
        return pos;
    }

    /**
     * Returns the offset of the component relative to the parent entity's position.
     *
     * @return the offset of the component
     */
    public Vector2D getOffset() {
        return offset;
    }

    /**
     * Sets the offset of the component relative to the parent entity's position.
     *
     * @param offset the new offset to set
     */
    public void setOffset(Vector2D offset) {
        this.offset = offset;
    }
}
