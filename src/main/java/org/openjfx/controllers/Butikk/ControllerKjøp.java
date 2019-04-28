package org.openjfx.controllers.Butikk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.exceptions.alertbox;

import java.io.IOException;

public class ControllerKjøp {


    @FXML
    private AnchorPane paneKjøp;


    /*Metode for å hente objekt fra forrige scene TODO Flytte i klasse og vekk fra controller??
    public void arrangementHenter(Arrangement arrangement){
        valgtArrangement = arrangement;
    }
    */




    @FXML
    private void actionBlaGjennomSide(ActionEvent event) throws IOException {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/sceneBlaGjennom.fxml"));
            paneKjøp.getChildren().setAll(pane);
            System.out.println("Tar det til Bla Gjennom siden.");
        } catch (IOException e) {
            alertbox.feil("En feil oppstod");
            e.printStackTrace();
        }
    }
}
