package engine.core;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        // launches the game as javafx wants it
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // creates the window
        System.out.println("Hello, World!");
    }
}