package space_core.example;

import engine.component.basic.Collider;
import engine.component.basic.Rectangle;
import engine.entity.Entity;
import engine.io.input.InputManager;
import engine.util.Vector2D;

import java.awt.event.KeyEvent;

/**
 * Represents an obstacle entity in the game.
 * This entity includes a rectangular shape and a collider for collision detection.
 */
public class ExampleEntityObstacle extends Entity {

    private Rectangle rect = (Rectangle) addComponent(new Rectangle(this));
    private Collider collider = (Collider) addComponent(new Collider(this));

    /**
     * Initializes the obstacle entity by setting its position, rectangle, and collider properties.
     * This method is called once when the entity is created.
     */
    @Override
    public void init() {
        super.init();
        this.pos.set(300, 0);
        rect.setOffset(new Vector2D(0, 0));
        rect.setSize(new Vector2D(100, 100));
        collider.setSize(new Vector2D(100, 100));
    }

    /**
     * Updates the entity's state each frame.
     * Currently, this method does not include any specific behavior for the obstacle.
     */
    @Override
    public void update() {
        super.update();
    }
}
