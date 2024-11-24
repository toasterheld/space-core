package space_core.example;

import engine.scene.Scene;

public class ExampleMaster extends Scene {

        public void init() {
            System.out.println("ExampleMaster init");
        }

        public void update() {
            System.out.println("ExampleMaster update");
        }

        public void render() {
            System.out.println("ExampleMaster render");
        }
        
        public boolean destroy() {
            return true;
        }
}
