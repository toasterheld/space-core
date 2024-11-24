package engine.component.basic;

import engine.component.Component;
import engine.entity.Entity;
import engine.io.graphics.Renderer;
import engine.util.Vector2D;

import java.awt.*;

public class Rectangle extends Component {

    Vector2D size = new Vector2D(0,0);
    Color color = Color.BLACK;

    public Rectangle(Entity parent) {
        super(parent);
    }


    @Override
    public void render(){
        Renderer.drawRectangle(getPos(), size, color);
    }

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
