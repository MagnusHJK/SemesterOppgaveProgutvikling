package org.openjfx.logic.Filhåndtering;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.*;
import java.io.File;
import org.openjfx.controllers.ControllerMain;

public abstract class fil {

    public static void start() {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Legg til fil");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files","*.csv","*.jobj","*.pdf"));
        fileChooser.showOpenDialog(stage);
    }

    public static File getFilnavn(FileChooser fileChooser) {
         return fileChooser.getInitialDirectory();
    }

}


