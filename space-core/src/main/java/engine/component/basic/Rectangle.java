package engine.component.basic;

import engine.component.Component;
import engine.entity.Entity;
import engine.io.graphics.Renderer;
import engine.util.Vector2D;

public class Rectangle extends Component {

    Vector2D size = new Vector2D(0,0);

    public Rectangle(Entity parent) {
        super(parent);
    }


    @Override
    public void render(){
        Renderer.drawRectangle(getPos(), size);
    }

    public void setSize(Vector2D size) {
        this.size = size;
    }

    public Vector2D getSize() {
        return size;
    }
}
