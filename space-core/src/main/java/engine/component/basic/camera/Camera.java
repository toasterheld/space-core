package engine.component.basic.camera;

import engine.component.Component;
import engine.entity.Entity;
import engine.io.graphics.Frame;
import engine.io.graphics.Renderer;
import engine.util.Vector2D;

public class Camera extends Component {
    public Camera(Entity parent) {
        super(parent);
    }

    public Vector2D getScreenPos(Vector2D worldPos){

        return worldPos.sub(getPos()).add(Renderer.getBufferSize().div(2));
    }



}
