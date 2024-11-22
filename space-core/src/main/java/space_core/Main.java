package space_core;

import engine.Engine;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Engine engine = new Engine();
        engine.init();
        engine.startGameLoop();
    }

    public static void main(String[] args) {
        launch();
    }
}