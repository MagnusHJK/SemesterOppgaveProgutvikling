package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementFilhåndtering;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Billett.Billett;
import org.openjfx.logic.Filhåndtering.*;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleFilhåndtering;
import org.openjfx.logic.Lokale.LokaleHåndtering;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonFilhåndtering;
import org.openjfx.logic.Person.PersonHåndtering;
import org.openjfx.logic.Person.PersonSerialiser;
import org.openjfx.logic.exceptions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ControllerAdminFilbehandling {


    @FXML
    private Button lesInnLokaler;
    @FXML
    private Button lesInnAraangement;
    @FXML
    private Button lesInnKontaktperson;

    // TODO finne en måte å legge til fra arrayet

    @FXML
    public void lesFraLokaler(ActionEvent event) throws IOException{
        LokaleFilhåndtering filhåndtering = new LokaleFilhåndtering();
        filhåndtering.lokaleLes();
    }

    @FXML
    private void skrivLokale(ActionEvent event){
        LokaleFilhåndtering filhåndtering = new LokaleFilhåndtering();
        filhåndtering.lokaleSkriv();
    }

    @FXML
    public void lesFraArrangement(ActionEvent event) throws IOException{
        ArrangementFilhåndtering filhåndtering = new ArrangementFilhåndtering();
        filhåndtering.arrangementLes();
    }

    @FXML
    public void skrivArrangement(ActionEvent event){
        ArrangementFilhåndtering filhåndtering = new ArrangementFilhåndtering();
        filhåndtering.arrangementSkriv();
    }


    @FXML
    public void lesFraPersoner(ActionEvent event) throws IOException{
        PersonFilhåndtering filhåndtering = new PersonFilhåndtering();
        filhåndtering.personLes();
    }

    @FXML
    private void skrivPerson(ActionEvent event){
        PersonFilhåndtering filhåndtering = new PersonFilhåndtering();
        filhåndtering.personSkriv();
    }

}


