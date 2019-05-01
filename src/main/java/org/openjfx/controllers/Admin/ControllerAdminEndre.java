package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.logic.Admin.Element;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementHåndtering;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Filhåndtering.skrivTilCsv;
import org.openjfx.logic.Filhåndtering.skrivTilFil;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonHåndtering;
import org.openjfx.logic.Person.PersonSerialiser;
import org.openjfx.logic.exceptions.*;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleCellFactory;
import org.openjfx.logic.Lokale.LokaleHåndtering;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ControllerAdminEndre{

    public void initialize() throws Exception{
        Element elementerListe = new Element();
        choiceEndre.setItems(elementerListe.lagElementListe());
    }

    @FXML
    private ListView<Lokale> listLokale;

    @FXML
    private ListView<Kontaktperson> listKontaktperson;

    @FXML
    private ListView<Arrangement> listArrangement;

    @FXML
    private AnchorPane paneAdminEndre;

    @FXML
    private ChoiceBox <String> choiceEndre;

    @FXML
    private Button btnEndre;

    @FXML
    private ChoiceBox<Kontaktperson> choiceKontaktpersonArr;

    @FXML
    public void endreInnhold (ActionEvent event) throws Exception {

        //LokaleHåndtering lokaler = new LokaleHåndtering();
        //LokaleSerialiser serialiser = new LokaleSerialiser();

        String valg = choiceEndre.getSelectionModel().getSelectedItem();

        if(valg.equals("Lokale")){
            listLokale.setVisible(true);
            //listKontaktperson.setVisible(false);
            //listArrangement.setVisible(false);

            try {
                LokaleSerialiser lSerialiser = new LokaleSerialiser();
                LokaleHåndtering håndtering = new LokaleHåndtering();
                ArrayList<Lokale> liste = lSerialiser.lesArrayFraFil();

                listLokale.setItems(håndtering.lagObservableList(liste));
            } catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }

        }else if(valg.equals("Kontaktperson")){

            try {
                PersonSerialiser pSerialiser = new PersonSerialiser();
                PersonHåndtering håndtering = new PersonHåndtering();
                ArrayList<Kontaktperson> liste = pSerialiser.lesArrayFraFil();

                //EndreTabell.setItems(håndtering.lagObservableList(liste));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(valg.equals("Arrangement")){

            try {
                ArrangementSerialiser aSerialiser = new ArrangementSerialiser();
                ArrangementHåndtering håndtering = new ArrangementHåndtering();
                ArrayList<Arrangement> liste = aSerialiser.lesArrayFraFil();

                //EndreTabell.setItems(håndtering.lagObservableList(liste));
            } catch(Exception e) {
                e.printStackTrace();
            }


        }
    }

    @FXML
    private void actionLokaleTrykk(MouseEvent event) { btnEndre.setDisable(false); }

    @FXML
    private Pane paneLokale;

    @FXML
    private TextField textfieldLokaleID;

    @FXML
    private TextField textfieldNavnLokale;

    @FXML
    private TextField textfieldTypeLokale;

    @FXML
    private TextField textfieldPlasserLokale;

    @FXML
    private void actionEndreElement(ActionEvent event) {
        String valg = choiceEndre.getSelectionModel().getSelectedItem();
        //Lokale etLokale = listLokale.getSelectionModel().getSelectedItem();

        if(valg.equals("Lokale")){
            paneLokale.setVisible(true);
            //paneKontaktperson.setVisible(false);
            //paneArrangement.setVisible(false);

        } else{

        }
    }

    @FXML
    private void actionEndreLokale(ActionEvent event) throws IOException, ClassNotFoundException, inputException {

        Lokale etLokale = listLokale.getSelectionModel().getSelectedItem();
        System.out.println("Du har trykket på endre lokale");

        String lokaleID = etLokale.getLokaleID();
        String navn = textfieldNavnLokale.getText();
        String type = textfieldTypeLokale.getText();
        int plasser = 0;

        //Prøver å konvertere plasser til int
        try{
            plasser = Integer.parseInt(textfieldPlasserLokale.getText());

        } catch(NumberFormatException nfe){
            alertbox.feil("Antall plasser er nødt til å være heltall.");
        }

        Lokale lokale = new Lokale(lokaleID, navn, type, plasser);
        LokaleHåndtering lokaleHåndtering = new LokaleHåndtering();
        lokaleHåndtering.endreLokale(lokale);
        textfieldLokaleID.clear();
        textfieldNavnLokale.clear();
        textfieldTypeLokale.clear();
        textfieldPlasserLokale.clear();

        try{


            //Henter det nåværende Array av Arrangementer og legger det nye Arrangementet inn
            LokaleSerialiser serialiser = new LokaleSerialiser();
            ArrayList<Lokale> liste = serialiser.lesArrayFraFil();

            //liste.add(lokale);
            System.out.println(liste);

            serialiser.skrivArrayTilFil(liste);

            /*// Lagerer på fil
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            String path = selectedFile.getPath();

            LokaleSerialiser lokaleSerialiser = new LokaleSerialiser();

            skrivTilFil skriv = new skrivTilCsv();
            skriv.LokaleTilCsv(lokaleSerialiser.lesArrayFraFil(),path);
            // Slutt*/

        } catch(IOException ioe){
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
        }
    }

}
