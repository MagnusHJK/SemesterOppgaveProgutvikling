package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.logic.Admin.Element;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementHåndtering;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Billett.Billett;
import org.openjfx.logic.Filhåndtering.skrivTilCsv;
import org.openjfx.logic.Filhåndtering.skrivTilFil;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonHåndtering;
import org.openjfx.logic.Person.PersonSerialiser;
import org.openjfx.logic.exceptions.*;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleHåndtering;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerAdminEndre {

    public void initialize() throws Exception {
        Element elementerListe = new Element();
        choiceEndre.setItems(elementerListe.lagElementListe());

        LokaleHåndtering lokaler = new LokaleHåndtering();
        LokaleSerialiser lokaleSerialiser = new LokaleSerialiser();

        PersonHåndtering personer = new PersonHåndtering();
        // midlertidig
        Kontaktperson.lagKontaktpersonListe();
        PersonSerialiser personSerialiser = new PersonSerialiser();
        Kontaktperson.lagKontaktpersonListe();

        //choiceKontaktperson.setItems(personer.lagObservableList(personSerialiser.lesArrayFraFil()));
        //choiceLokale.setItems(lokaler.lagObservableList(lokaleSerialiser.lesArrayFraFil()));
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
    private ChoiceBox<String> choiceEndre;

    @FXML
    private Button btnEndre;

    @FXML
    private Button btnEndre2;

    @FXML
    private ChoiceBox<Kontaktperson> choiceKontaktpersonArr;

    @FXML
    public void endreInnhold(ActionEvent event) throws Exception {

        //LokaleHåndtering lokaler = new LokaleHåndtering();
        //LokaleSerialiser serialiser = new LokaleSerialiser();

        String valg = choiceEndre.getSelectionModel().getSelectedItem();

        if (valg.equals("Lokale")) {
            listLokale.setVisible(true);
            paneLokale.setVisible(true);
            //listKontaktperson.setVisible(false);
            //listArrangement.setVisible(false);

            try {
                LokaleSerialiser lSerialiser = new LokaleSerialiser();
                LokaleHåndtering håndtering = new LokaleHåndtering();
                ArrayList<Lokale> liste = lSerialiser.lesArrayFraFil();

                listLokale.setItems(håndtering.lagObservableList(liste));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        } /*else if (valg.equals("Kontaktperson")) {
            //listArrangement.setVisible(true);

            try {
                PersonSerialiser pSerialiser = new PersonSerialiser();
                PersonHåndtering håndtering = new PersonHåndtering();
                ArrayList<Kontaktperson> liste = pSerialiser.lesArrayFraFil();

                //EndreTabell.setItems(håndtering.lagObservableList(liste));

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (valg.equals("Arrangement")) {
            listArrangement.setVisible(true);
            listLokale.setVisible(false);

            try {
                ArrangementSerialiser aSerialiser = new ArrangementSerialiser();
                ArrangementHåndtering håndtering = new ArrangementHåndtering();
                ArrayList<Arrangement> liste = aSerialiser.lesArrayFraFil();

                listArrangement.setItems(håndtering.lagObservableList(liste));
            } catch (Exception e) {
                e.printStackTrace();
            }


        }*/
    }

    @FXML
    private void actionLokaleTrykk(MouseEvent event) {
        btnEndre.setDisable(false);
    }

    @FXML
    private void actionArrangementTrykk(MouseEvent event) {
        btnEndre.setDisable(false);
    }

    // Lokale
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
    private Button btnEndreLokale;


    // Arrangement
    @FXML
    private Pane paneArrangement;

    @FXML
    private ChoiceBox choiceKontaktperson;

    @FXML
    private ChoiceBox choiceLokale;

    @FXML
    private TextField textfieldNavn;

    @FXML
    private TextField textfieldArtist;

    @FXML
    private TextField textfieldSted;

    @FXML
    private DatePicker dateDato;

    @FXML
    private TextField textfieldTidspunkt;

    @FXML
    private TextField textfieldBillettpris;

    @FXML
    private TextField textfieldMaksBilletter;

    @FXML
    private TextArea textareaBeskrivelse;

    @FXML
    private void actionEndreElement(ActionEvent event) throws Exception{
        //paneLokale.setDisable(false);
        String valg = choiceEndre.getSelectionModel().getSelectedItem();
        //Lokale etLokale = listLokale.getSelectionModel().getSelectedItem();

        if (valg.equals("Lokale")) {
            paneLokale.setVisible(true);
            btnEndreLokale.setDisable(false);
            //paneLokale.setDisable(false);

            //paneArrangement.setVisible(false);


            try {
                LokaleSerialiser serialiser = new LokaleSerialiser();
                LokaleHåndtering håndtering = new LokaleHåndtering();
                ArrayList<Lokale> liste = serialiser.lesArrayFraFil();

                listLokale.setItems(håndtering.lagObservableList(liste));
            } catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }

        } /*else if (valg.equals("Arrangement")) {
            paneArrangement.setVisible(true);
            paneLokale.setVisible(false);

            try{
                ArrangementSerialiser serialiser = new ArrangementSerialiser();
                ArrangementHåndtering håndtering = new ArrangementHåndtering();
                ArrayList<Arrangement> liste = serialiser.lesArrayFraFil();

                listArrangement.setItems(håndtering.lagObservableList(liste));
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        } */else {

        }
    }

    @FXML
    private void actionEndreLokale(ActionEvent event) throws IOException, ClassNotFoundException, inputException {
        //paneLokale.setDisable(false);

        Lokale etLokale = listLokale.getSelectionModel().getSelectedItem();
        System.out.println("Du har trykket på endre lokale");

        String lokaleID = etLokale.getLokaleID();
        String navn = textfieldNavnLokale.getText();
        String type = textfieldTypeLokale.getText();
        int plasser = 0;


        //Prøver å konvertere plasser til int
        try {
            plasser = Integer.parseInt(textfieldPlasserLokale.getText());

        } catch (NumberFormatException nfe) {
            alertbox.feil("Antall plasser er nødt til å være heltall.");
        }

        Lokale lokale = new Lokale(lokaleID, navn, type, plasser);
        LokaleHåndtering lokaleHåndtering = new LokaleHåndtering();
        lokaleHåndtering.endreLokale(lokale);
        textfieldLokaleID.clear();
        textfieldNavnLokale.clear();
        textfieldTypeLokale.clear();
        textfieldPlasserLokale.clear();

        try {


            //Henter det nåværende Array av Arrangementer og legger det nye Arrangementet inn
            LokaleSerialiser serialiser = new LokaleSerialiser();
            ArrayList<Lokale> liste = serialiser.lesArrayFraFil();

            //liste.add(lokale);
            System.out.println(liste);

            serialiser.skrivArrayTilFil(liste);

            // Lagerer på fil
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            String path = selectedFile.getPath();

            LokaleSerialiser lokaleSerialiser = new LokaleSerialiser();

            skrivTilFil skriv = new skrivTilCsv();
            skriv.LokaleTilCsv(lokaleSerialiser.lesArrayFraFil(),path);
            // Slutt

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }
    }

    /*@FXML
    private void actionEndreArrangement(ActionEvent event) throws IOException, ClassNotFoundException, inputException {
        Arrangement etArrangement = listArrangement.getSelectionModel().getSelectedItem();
        System.out.println("Du har trykket på legg til arrangement");

        String arrangementID = etArrangement.getArrangementID();
        //Kontaktperson kontaktperson = choiceKontaktperson.getSelectionModel().getSelectedItem();
        //Lokale lokale = choiceLokale.getSelectionModel().getSelectedItem();
        //Kontaktperson enKontaktperson = (Kontaktperson) choiceKontaktperson.getSelectionModel().getSelectedItem();
        //Lokale etLokale = (Lokale) choiceLokale.getSelectionModel().getSelectedItem();
        Kontaktperson kontaktperson = (Kontaktperson) choiceKontaktperson.getSelectionModel().getSelectedItem();
        Lokale lokale = (Lokale) choiceLokale.getSelectionModel().getSelectedItem();
        String navn = textfieldNavn.getText();
        String artist = textfieldArtist.getText();
        String sted = textfieldSted.getText();
        LocalDate dato = dateDato.getValue();
        String tidspunkt = textfieldTidspunkt.getText();
        String beskrivelse = textareaBeskrivelse.getText();
        int billettPris = 0;
        int billettMaks = 0;
        boolean ok = true;

        // Sjekk om feltene er tomme
        try {
            if (navn.isEmpty() ||
                    artist.isEmpty() || sted.isEmpty() || beskrivelse.isEmpty()) {
                ok = false;
                throw new inputException();

            }

        } catch (inputException ie) {
            alertbox.feil(inputException.emptyException());

        }

        // Sjekk om menyene er lik NULL
        try {
            if (kontaktperson == null || lokale == null) {
                ok = false;
                throw new NullPointerException();
            }
        } catch (NullPointerException npe) {
            alertbox.feil(inputException.nullexception());

        }


        // Sjekker om input feltene inneholder tall der det trengs
        try {
            billettPris = Integer.parseInt(textfieldBillettpris.getText());
            billettMaks = Integer.parseInt(textfieldMaksBilletter.getText());
            //ok = false;
            // throw new inputException();
        } catch (NumberFormatException nfe) {
            alertbox.feil(inputException.intException());

        }

        if (!ok) {

        } else {
            Billett[] billett = new Billett[billettMaks];

            Arrangement arrangement = new Arrangement(arrangementID, kontaktperson, lokale, navn, artist, sted, dato, tidspunkt, beskrivelse, billettPris, billettMaks, billett);
            //textfieldArrangementID.clear();
            textfieldNavn.clear();
            textfieldArtist.clear();
            textfieldSted.clear();
            textfieldTidspunkt.clear();
            textfieldBillettpris.clear();
            textfieldMaksBilletter.clear();
            textareaBeskrivelse.clear();

            try {
                //Henter det nåværende Array av Arrangementer og legger det nye Arrangementet inn
                ArrangementSerialiser serialiser = new ArrangementSerialiser();
                ArrayList<Arrangement> liste = serialiser.lesArrayFraFil();

                liste.add(arrangement);
                System.out.println(liste);

                serialiser.skrivArrayTilFil(liste);

                // Lagerer på fil
                Stage stage = new Stage();
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
                File selectedFile = fileChooser.showOpenDialog(stage);
                String path = selectedFile.getPath();

                ArrangementSerialiser arrangementSerialiser = new ArrangementSerialiser();

                skrivTilFil skriv = new skrivTilCsv();
                skriv.ArrangementTilCsv(arrangementSerialiser.lesArrayFraFil(), path);
                // Slutt


            } catch (IOException | ClassNotFoundException cnf) {
                cnf.printStackTrace();
            }
        }

    }*/
}
