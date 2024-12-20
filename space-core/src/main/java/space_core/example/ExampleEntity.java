package space_core.example;

import engine.component.basic.Collider;
import engine.component.basic.Image;
import engine.component.basic.Rectangle;
import engine.component.basic.Text;
import engine.component.basic.camera.Camera;
import engine.entity.Entity;
import engine.io.input.InputManager;
import engine.util.Vector2D;
import javafx.scene.input.KeyCode;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * An example entity class demonstrating basic entity behavior and component usage.
 * This entity includes a rectangle for visuals, a collider for collision detection,
 * and a camera for viewport manipulation.
 */
public class ExampleEntity extends Entity {

    private Rectangle rect = (Rectangle) addComponent(new Rectangle(this));
    private Collider collider = (Collider) addComponent(new Collider(this));
    private Camera cam = (Camera) addComponent(new Camera(this));

    /**
     * Initializes the example entity by setting up its rectangle and collider properties.
     * This method is called once when the entity is created.
     */
    @Override
    public void init() {
        super.init();
        rect.setOffset(new Vector2D(0, 0));
        rect.setSize(new Vector2D(100, 100));
        collider.setSize(new Vector2D(100, 100));
    }

    /**
     * Updates the entity's state each frame.
     * This method checks for user input and moves the entity accordingly.
     */
    @Override
    public void update() {
        super.update();
        if (InputManager.isKeyDown(KeyEvent.VK_W)) {
            pos.add(new Vector2D(10, 0));
        }
    }

    /**
     * Gets the camera component associated with this entity.
     *
     * @return The camera component.
     */
    public Camera getCam() {
        return cam;
    }
}
