module com.example.spacecore {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens engine to javafx.fxml;
    exports engine;
    exports space_core;
    opens space_core to javafx.fxml;
    exports engine.util;
    opens engine.util to javafx.fxml;
    exports engine.graphics;
    opens engine.graphics to javafx.fxml;
}