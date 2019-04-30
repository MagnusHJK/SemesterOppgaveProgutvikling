module hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx to javafx.fxml;
    opens org.openjfx.controllers to javafx.fxml;
    opens org.openjfx.controllers.Admin to javafx.fxml;
    opens org.openjfx.controllers.Butikk to javafx.fxml;
    opens org.openjfx.logic.Lokale to javafx.base;
    opens org.openjfx.logic.Arrangement to javafx.base;
    opens org.openjfx.logic.Billett to javafx.fxml;


    exports org.openjfx.controllers;
    exports org.openjfx.controllers.Admin;
    exports org.openjfx.controllers.Butikk;
    exports org.openjfx.logic.Billett;
    exports org.openjfx;
}