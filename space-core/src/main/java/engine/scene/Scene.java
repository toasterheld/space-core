package engine.scene;

import engine.entity.Entity;

import java.util.ArrayList;

public class Scene {

    private ArrayList<Entity> entities = new ArrayList<Entity>();


    protected Entity addEntity(Entity entity){
        entities.add(entity);
        return entity;
    }

    public void init() {
        for(Entity entity : entities){
            entity.init();
        }
    }

    public void update() {
        for(Entity entity : entities){
            entity.update();
        }

    }

    public void render() {
        for(Entity entity : entities){
            entity.render();
        }
    }

    public boolean destroy() {
        return true;
    }
}
