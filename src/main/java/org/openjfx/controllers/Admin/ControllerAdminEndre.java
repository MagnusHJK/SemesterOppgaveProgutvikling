package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.openjfx.logic.Admin.Element;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementHåndtering;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonHåndtering;
import org.openjfx.logic.Person.PersonSerialiser;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleCellFactory;
import org.openjfx.logic.Lokale.LokaleHåndtering;
import org.openjfx.logic.exceptions.valgException;
import org.openjfx.logic.exceptions.nullException;
import org.openjfx.logic.exceptions.arrangementException;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerAdminEndre{

    public void initialize() throws Exception{
        Element elementerListe = new Element();
        choiceEndre.setItems(elementerListe.lagElementListe());
    }

    @FXML
    private ListView EndreTabell;

    @FXML
    private AnchorPane paneAdminEndre;

    @FXML
    private ChoiceBox <String> choiceEndre;

    @FXML
    private Button btnEndre;

    @FXML
    private ChoiceBox<Kontaktperson> choiceKontaktpersonArr;

    private void endreInnhold (ActionEvent event) throws Exception {

        LokaleHåndtering lokaler = new LokaleHåndtering();
        LokaleSerialiser serialiser = new LokaleSerialiser();

        String valg = choiceEndre.getSelectionModel().getSelectedItem();

        if(valg.equals("Lokale")){
            try {
                LokaleSerialiser lSerialiser = new LokaleSerialiser();
                LokaleHåndtering håndtering = new LokaleHåndtering();
                ArrayList<Lokale> liste = lSerialiser.lesArrayFraFil();

                EndreTabell.setItems(håndtering.lagObservableList(liste));
            } catch(Exception e) {
                e.printStackTrace();
            }

        }else if(valg.equals("Kontaktperson")){

            try {
                PersonSerialiser pSerialiser = new PersonSerialiser();
                PersonHåndtering håndtering = new PersonHåndtering();
                ArrayList<Kontaktperson> liste = pSerialiser.lesArrayFraFil();

                EndreTabell.setItems(håndtering.lagObservableList(liste));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(valg.equals("Arrangement")){

            try {
                ArrangementSerialiser aSerialiser = new ArrangementSerialiser();
                ArrangementHåndtering håndtering = new ArrangementHåndtering();
                ArrayList<Arrangement> liste = aSerialiser.lesArrayFraFil();

                EndreTabell.setItems(håndtering.lagObservableList(liste));
            } catch(Exception e) {
                e.printStackTrace();
            }


        }
    }

}
