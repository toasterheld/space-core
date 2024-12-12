package engine.entity;

import engine.component.Component;
import engine.util.Vector2D;

import java.util.ArrayList;

/**
 * Represents an entity in the game world.
 * An entity is a container for components that define its behavior and appearance in the world.
 * It handles the initialization, update, and render cycles for all components attached to it.
 */
public class Entity {

    // The position of the entity in the world
    protected Vector2D pos;

    // The list of components attached to this entity
    protected ArrayList<Component> components = new ArrayList<Component>();

    /**
     * Constructs a new Entity with a default position (0, 0).
     */
    public Entity() {
        pos = new Vector2D(0, 0);
    }

    /**
     * Adds a component to the entity.
     * The component is added to the entity's list of components and will be updated and rendered as part of the entity.
     *
     * @param component the component to add to the entity
     * @return the component that was added
     */
    protected Component addComponent(Component component) {
        components.add(component);
        return component;
    }

    /**
     * Initializes all components attached to the entity.
     * This method will call the `init` method of every component.
     */
    public void init() {
        for (Component component : components) {
            component.init();
        }
    }

    /**
     * Updates all components attached to the entity.
     * This method will call the `update` method of every component.
     */
    public void update() {
        for (Component component : components) {
            component.update();
        }
    }

    /**
     * Renders all components attached to the entity.
     * This method will call the `render` method of every component.
     */
    public void render() {
        for (Component component : components) {
            component.render();
        }
    }

    /**
     * Returns the current position of the entity in the world.
     *
     * @return the position of the entity
     */
    public Vector2D getPos() {
        return pos;
    }

    /**
     * Sets the position of the entity in the world.
     *
     * @param pos the new position of the entity
     */
    public void setPos(Vector2D pos) {
        this.pos = pos;
    }
}
