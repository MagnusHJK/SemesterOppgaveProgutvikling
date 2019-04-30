package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.openjfx.logic.Filhåndtering.csvFil;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.Filhåndtering.fil;

import java.io.IOException;

public class ControllerAdminFilbehandling {


    @FXML
    private Button lesInnLokaler;
    @FXML
    private Button lesInnAraangement;
    @FXML
    private Button lesInnKontaktperson;

    // TODO finne en måte å legge til fra arrayet

    public void lesFraLokaler(ActionEvent event) throws IOException{
       fil lesCsv = new csvFil();
       lesCsv.lesCsvFil();

    }

    public void lesFraArrangement(ActionEvent event) throws IOException{
        fil lesCsv = new csvFil();
        lesCsv.lesCsvFil();

    }

    public void lesFraPersoner(ActionEvent event) throws IOException{
        fil lesCsv = new csvFil();
        lesCsv.lesCsvFil();
    }

}


