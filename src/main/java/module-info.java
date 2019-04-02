module hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx to javafx.fxml;
    opens org.openjfx.controllers to javafx.fxml;
    opens org.openjfx.logic.Lokale to javafx.base;
    opens org.openjfx.logic.Arrangement to javafx.base;


    exports org.openjfx.controllers;
    exports org.openjfx;
}