package engine.component;

import engine.entity.Entity;
import engine.util.Vector2D;

public class Component {

    private Vector2D pos;
    private Vector2D offset;

    public Component(Entity parent){
        pos = parent.getPos().add(offset);
    }

    public void init(){

    }

    public void update(){

    }

    public void render(){

    }
}
