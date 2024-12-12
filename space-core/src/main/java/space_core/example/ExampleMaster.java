package space_core.example;

import engine.entity.Entity;
import engine.scene.Scene;
import space_core.planet.Player;

import static engine.component.basic.camera.CameraManager.setActiveCamera;

/**
 * ExampleMaster is a specific implementation of a game scene.
 * It initializes and manages the entities and their interactions within the scene.
 */
public class ExampleMaster extends Scene {

        ExampleEntityObstacle entity2 = (ExampleEntityObstacle) addEntity(new ExampleEntityObstacle());
        Player entity = (Player) addEntity(new Player());

        /**
         * Initializes the scene by adding entities and setting up the active camera.
         * This method is called once when the scene is created.
         */
        @Override
        public void init() {
                super.init();
                setActiveCamera(entity.getCam());
        }

        /**
         * Updates the state of the scene and its entities each frame.
         * This method is called continuously during the game loop.
         */
        @Override
        public void update() {
                super.update();
        }

        /**
         * Renders the scene and its entities to the screen each frame.
         * This method is called continuously during the game loop.
         */
        @Override
        public void render() {
                super.render();
        }

        /**
         * Destroys the scene and releases any associated resources.
         *
         * @return true if the scene is successfully destroyed; otherwise false.
         */
        @Override
        public boolean destroy() {
                return true;
        }
}
