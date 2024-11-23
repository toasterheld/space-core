package engine.component;

import engine.entity.Entity;
import engine.util.Vector2D;

public class Component {

    private Vector2D pos;
    protected Vector2D offset;

    public Component(Entity parent){
        offset = new Vector2D(0,0);
        pos = parent.getPos().add(offset);
    }

    public void init(){

    }

    public void update(){

    }

    public void render(){

    }


    protected Vector2D getPos(){
        return pos;
    }

    public Vector2D getOffset() {
        return offset;
    }

    public void setOffset(Vector2D offset) {
        this.offset = offset;
    }
}
