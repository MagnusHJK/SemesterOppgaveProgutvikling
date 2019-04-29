package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.Filhåndtering.fil;

public class ControllerAdminFilbehandling {


    @FXML
    private Button lesInnLokaler;
    @FXML
    private Button lesInnAraangement;
    @FXML
    private Button lesInnKontaktperson;

    public void lesFraLokaler(ActionEvent event) {
        fil.start();
        // fil.getFilnavn();
    }

    public void lesFraArrangement(ActionEvent event) {

    }

    public void lesFraPersoner(ActionEvent event) {

    }

}


