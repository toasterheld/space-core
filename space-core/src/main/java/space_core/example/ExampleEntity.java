package space_core.example;

import engine.component.basic.Collider;
import engine.component.basic.Image;
import engine.component.basic.Rectangle;
import engine.component.basic.Text;
import engine.entity.Entity;
import engine.io.input.InputManager;
import engine.util.Vector2D;
import javafx.scene.input.KeyCode;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ExampleEntity extends Entity {
    private Rectangle rect = (Rectangle) addComponent(new Rectangle(this));
    private Collider collider = (Collider) addComponent(new Collider(this));

    @Override
    public void init() {
        super.init();
        rect.setOffset(new Vector2D(0, 0));
        rect.setSize(new Vector2D(100,100));
        collider.setSize(new Vector2D(100,100));
    }


    @Override
    public void update() {
        super.update();
        if(InputManager.isKeyDown(KeyEvent.VK_W)){
            pos.add(new Vector2D(10,0));
        }
    }
}
