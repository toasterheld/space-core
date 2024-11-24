package space_core.example;

import engine.entity.Entity;
import engine.scene.Scene;

public class ExampleMaster extends Scene {


        ExampleEntity entity = (ExampleEntity) addEntity(new ExampleEntity());

        @Override
        public void init() {
                super.init();
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
