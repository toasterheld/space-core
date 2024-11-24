package space_core.example;

import engine.component.basic.Collider;
import engine.component.basic.Rectangle;
import engine.entity.Entity;
import engine.io.input.InputManager;
import engine.util.Vector2D;

import java.awt.event.KeyEvent;

public class ExampleEntityObstacle extends Entity {
    private Rectangle rect = (Rectangle) addComponent(new Rectangle(this));
    private Collider collider = (Collider) addComponent(new Collider(this));

    @Override
    public void init() {
        super.init();
        this.pos.set(300,0);
        rect.setOffset(new Vector2D(0, 0));
        rect.setSize(new Vector2D(100,100));
        collider.setSize(new Vector2D(100,100));
    }


    @Override
    public void update() {
        super.update();
    }
}
