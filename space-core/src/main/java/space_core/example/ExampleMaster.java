package space_core.example;

import engine.entity.Entity;
import engine.scene.Scene;
import space_core.planet.Player;

import static engine.component.basic.camera.CameraManager.setActiveCamera;

public class ExampleMaster extends Scene {


        ExampleEntityObstacle entity2 = (ExampleEntityObstacle) addEntity(new ExampleEntityObstacle());

        Player entity = (Player) addEntity(new Player());


        @Override
        public void init() {
                super.init();

                setActiveCamera(entity.getCam());



        }

        @Override
        public void update() {
                super.update();
        }

        @Override
        public void render() {
                super.render();
        }
        
        public boolean destroy() {
            return true;
        }
}
