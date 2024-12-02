package engine.entity;

import engine.component.Component;
import engine.util.Vector2D;

import java.util.ArrayList;

public class Entity {
    protected Vector2D pos;
    protected ArrayList<Component> components = new ArrayList<Component>();

    public Entity(){
        pos = new Vector2D(0,0);
    }

    protected Component addComponent(Component component){
        components.add(component);
        return component;
    }


    public void init(){
        for(Component component : components) {
            component.init();
        }
    }

    public void update(){
        for(Component component : components) {
            component.update();
        }
    }

    public void render(){
        for(Component component : components) {
            component.render();
        }
    }


    public Vector2D getPos() {
        return pos;
    }


    public void setPos(Vector2D pos) {
        this.pos = pos;
    }
}
