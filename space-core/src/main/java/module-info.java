module com.example.spacecore {
    requires javafx.controls;
    requires javafx.fxml;


    opens engine to javafx.fxml;
    exports engine;
}