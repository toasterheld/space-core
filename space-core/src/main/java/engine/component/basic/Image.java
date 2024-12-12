package engine.component.basic;

import engine.component.Component;
import engine.entity.Entity;
import engine.io.graphics.Renderer;
import engine.util.Util;
import engine.util.Vector2D;

import java.awt.image.BufferedImage;

/**
 * Represents an image component that can be attached to an entity.
 * This component allows loading and rendering images on the screen, with a configurable size.
 */
public class Image extends Component {

    private BufferedImage image;
    private Vector2D size;

    /**
     * Constructs an Image component with the default missing image.
     * The missing image is loaded from the file path "/textures/missing.png".
     *
     * @param parent the parent entity to which this image component belongs
     */
    public Image(Entity parent){
        super(parent);
        image = Util.getBufferedImage("/textures/missing.png");
    }

    /**
     * Constructs an Image component with a specified image file path.
     * The image is loaded and the size is set based on the image's width and height.
     *
     * @param path   the file path of the image to load
     * @param parent the parent entity to which this image component belongs
     */
    public Image(String path, Entity parent){
        super(parent);
        image = Util.getBufferedImage(path);
        size = new Vector2D(image.getWidth(), image.getHeight());
    }

    /**
     * Initializes the image component. This method can be overridden for further initialization logic.
     */
    public void init(){
    }

    /**
     * Updates the image component. This method can be overridden for custom update logic.
     */
    public void update(){
    }

    /**
     * Renders the image at the current position with the specified size.
     * The rendering is handled by the Renderer utility.
     */
    public void render(){
        Renderer.drawImage(image, getPos(), size);
    }

    // Getter and Setter methods

    public void setImage(String path) {
        this.image = Util.getBufferedImage(path);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setSize(Vector2D size) {
        this.size = size;
    }

    public Vector2D getSize() {
        return size;
    }
}
