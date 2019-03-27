module hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx to javafx.fxml;
    opens org.openjfx.controllers;

    exports org.openjfx.controllers;
    exports org.openjfx;
}