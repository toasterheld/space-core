package engine.component.basic.camera;

import engine.component.Component;
import engine.entity.Entity;
import engine.io.graphics.Frame;
import engine.io.graphics.Renderer;
import engine.util.Vector2D;

/**
 * Represents a camera component that can be attached to an entity.
 * This component is used to convert world coordinates into screen coordinates
 * based on the camera's position and the rendering buffer size.
 */
public class Camera extends Component {

    /**
     * Constructs a Camera component associated with the specified parent entity.
     *
     * @param parent the parent entity to which this camera component belongs
     */
    public Camera(Entity parent) {
        super(parent);
    }

    /**
     * Converts a world position to a screen position based on the camera's position
     * and the rendering buffer size.
     *
     * @param worldPos the position in the world to be converted to screen coordinates
     * @return the screen position corresponding to the world position
     */
    public Vector2D getScreenPos(Vector2D worldPos) {
        // Calculate the screen position by subtracting the camera's position
        // and adding half of the buffer size to center the world in the screen
        return worldPos.sub(getPos()).add(Renderer.getBufferSize().div(2));
    }
}
