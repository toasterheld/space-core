package space_core.planet;

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
 * Represents the player entity in the game.
 * The player can move in response to input and has associated components such as a rectangle, collider, and camera.
 */
public class Player extends Entity {
    private Rectangle rect = (Rectangle) addComponent(new Rectangle(this));
    private Collider collider = (Collider) addComponent(new Collider(this));
    private Camera cam = (Camera) addComponent(new Camera(this));
    private double speed = 5;

    /**
     * Initializes the player entity.
     * Sets up the player's rectangle and collider properties.
     */
    @Override
    public void init() {
        super.init();
        rect.setOffset(new Vector2D(0, 0));
        rect.setSize(new Vector2D(100, 100));
        collider.setSize(new Vector2D(100, 100));
    }

    /**
     * Updates the player's position based on input.
     * Handles movement for keys W, A, S, D to adjust the player's position in the game world.
     */
    @Override
    public void update() {
        super.update();

        Vector2D mov = new Vector2D();
        double currentSpeed = speed;

        if (InputManager.isKeyDown(KeyEvent.VK_W)) mov.add(new Vector2D(0, -currentSpeed));
        if (InputManager.isKeyDown(KeyEvent.VK_A)) mov.add(new Vector2D(-currentSpeed, 0));
        if (InputManager.isKeyDown(KeyEvent.VK_S)) mov.add(new Vector2D(0, +currentSpeed));
        if (InputManager.isKeyDown(KeyEvent.VK_D)) mov.add(new Vector2D(+currentSpeed, 0));

        pos.add(mov);
    }

    /**
     * Retrieves the camera associated with the player.
     *
     * @return the camera component attached to the player.
     */
    public Camera getCam() {
        return cam;
    }
}
