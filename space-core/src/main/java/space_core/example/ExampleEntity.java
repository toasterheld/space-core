package space_core.example;

import engine.component.basic.Image;
import engine.component.basic.Rectangle;
import engine.component.basic.Text;
import engine.entity.Entity;
import engine.util.Vector2D;

import java.awt.*;

public class ExampleEntity extends Entity {
    private Image rect = (Image)addComponent(new Image(this));

    @Override
    public void init() {
        rect.setOffset(new Vector2D(0, 0));
    }


}
