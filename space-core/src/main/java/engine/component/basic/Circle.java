package engine.component.basic;

import engine.component.Component;
import engine.entity.Entity;
import engine.io.graphics.Renderer;

public class Circle extends Component {

    private int radius = 0;
    public Circle(Entity parent) {
        super(parent);
    }


    @Override
    public void render(){
        Renderer.drawCircle(getPos(), radius);
    }

    public void getRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}
