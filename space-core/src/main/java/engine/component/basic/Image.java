package engine.component.basic;

import engine.component.Component;
import engine.entity.Entity;
import engine.io.graphics.Renderer;
import engine.util.Util;
import engine.util.Vector2D;

import java.awt.image.BufferedImage;


public class Image extends Component {

    private BufferedImage image;
    private Vector2D size;

    public Image(Entity parent){
        super(parent);
    }


    public Image(String path, Entity parent){
        super(parent);
        image = Util.getBufferedImage(path);
        size = new Vector2D(image.getWidth(),image.getHeight());
    }


    public void init(){

    }

    public void update(){

    }

    public void render(){
        Renderer.drawImage(image, getPos(), size);
    }


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
