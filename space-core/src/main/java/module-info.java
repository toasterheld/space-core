module com.example.spacecore {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;
    requires com.google.gson;


    opens engine to javafx.fxml;
    exports engine;
    exports space_core;
    opens space_core to javafx.fxml;
    exports engine.util;
    opens engine.util to javafx.fxml;
    exports engine.io.graphics;
    opens engine.io.graphics to javafx.fxml;
}