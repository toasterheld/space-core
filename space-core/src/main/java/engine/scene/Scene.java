package engine.scene;

import engine.entity.Entity;

import java.util.ArrayList;

/**
 * The Scene class represents a collection of entities in a scene. It is responsible for
 * managing and updating the entities, as well as rendering them to the screen.
 */
public class Scene {

    // List of entities in the scene
    private ArrayList<Entity> entities = new ArrayList<Entity>();

    /**
     * Adds an entity to the scene and returns the added entity.
     *
     * @param entity the entity to be added to the scene
     * @return the entity that was added
     */
    protected Entity addEntity(Entity entity){
        entities.add(entity);
        return entity;
    }

    /**
     * Initializes all entities in the scene. This method calls the {@code init()} method
     * of each entity.
     */
    public void init() {
        for(Entity entity : entities){
            entity.init();
        }
    }

    /**
     * Updates all entities in the scene. This method calls the {@code update()} method
     * of each entity.
     */
    public void update() {
        for(Entity entity : entities){
            entity.update();
        }
    }

    /**
     * Renders all entities in the scene. This method calls the {@code render()} method
     * of each entity to draw them to the screen.
     */
    public void render() {
        for(Entity entity : entities){
            entity.render();
        }
    }

    /**
     * Destroys the scene. This method can be used for cleanup or resource management.
     *
     * @return {@code true} indicating the destruction is successful.
     */
    public boolean destroy() {
        return true;
    }
}
