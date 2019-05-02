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
        PersonSerialiser personSerialiser = new PersonSerialiser();

        choiceLokale.setItems(lokaler.lagObservableList(lokaleSerialiser.lesArrayFraFil()));

        choicePerson.setItems(personer.lagObservableList(personSerialiser.lesArrayFraFil()));
    }

    @FXML
    private ListView<Lokale> listLokale;

    @FXML
    private ListView<Kontaktperson> listKontaktperson;

    @FXML
    private ListView<Arrangement> listArrangement;

    @FXML
    private ChoiceBox<String> choiceEndre;

    @FXML
    public void endreInnhold(ActionEvent event) throws Exception {
        String valg = choiceEndre.getSelectionModel().getSelectedItem();

        if (valg.equals("Lokale")) {
            listLokale.setVisible(true);
            paneLokale.setVisible(true);
            listKontaktperson.setVisible(false);
            paneKontaktperson.setVisible(false);
            listArrangement.setVisible(false);
            paneArrangement.setVisible(false);

            try {
                LokaleSerialiser lSerialiser = new LokaleSerialiser();
                LokaleHåndtering håndtering = new LokaleHåndtering();
                ArrayList<Lokale> liste = lSerialiser.lesArrayFraFil();

                listLokale.setItems(håndtering.lagObservableList(liste));
            } catch (IOException | ClassNotFoundException e) {
                alertbox.feil(klasseException.klasseException());
            }

        } else if (valg.equals("Kontaktperson")) {
            listKontaktperson.setVisible(true);
            paneKontaktperson.setVisible(true);
            listLokale.setVisible(false);
            paneLokale.setVisible(false);
            listArrangement.setVisible(false);
            paneArrangement.setVisible(false);

            try {
                PersonSerialiser pSerialiser = new PersonSerialiser();
                PersonHåndtering håndtering = new PersonHåndtering();
                ArrayList<Kontaktperson> liste = pSerialiser.lesArrayFraFil();

                listKontaktperson.setItems(håndtering.lagObservableList(liste));

            } catch (Exception e) {
                alertbox.feil(opprettException.opprettException());
            }
        } else if (valg.equals("Arrangement")) {
            listArrangement.setVisible(true);
            paneArrangement.setVisible(true);
            listLokale.setVisible(false);
            paneLokale.setVisible(false);
            listKontaktperson.setVisible(false);
            paneKontaktperson.setVisible(false);


            try {
                ArrangementSerialiser aSerialiser = new ArrangementSerialiser();
                ArrangementHåndtering håndtering = new ArrangementHåndtering();
                ArrayList<Arrangement> liste = aSerialiser.lesArrayFraFil();

                listArrangement.setItems(håndtering.lagObservableList(liste));
            } catch (Exception e) {
                alertbox.feil(opprettException.opprettException());
            }


        }
    }

    // Lokale FXML
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

    // Kontaktperson FXML
    @FXML
    private Pane paneKontaktperson;

    @FXML
    private TextField textfieldFornavnPerson;

    @FXML
    private TextField textfieldEtternavnPerson;

    @FXML
    private TextField textfieldTlfPerson;

    @FXML
    private TextField textfieldEpostPerson;

    @FXML
    private TextField textfieldNettsidePerson;

    @FXML
    private TextField textfieldVirksomhetPerson;

    @FXML
    private TextArea textareaOpplysningerPerson;

    // Arrangement FXML
    @FXML
    private Pane paneArrangement;

    @FXML
    private ChoiceBox<Kontaktperson> choicePerson;

    @FXML
    private ChoiceBox<Lokale> choiceLokale;

    @FXML
    private TextField textfieldNavnArr;

    @FXML
    private TextField textfieldArtistArr;

    @FXML
    private TextField textfieldStedArr;

    @FXML
    private DatePicker datoDatoArr;

    @FXML
    private TextField textfieldTidspunktArr;

    @FXML
    private TextField textfieldBillettprisArr;

    @FXML
    private TextField textfieldMaksBilletterArr;

    @FXML
    private TextArea textareaBeskrivelse;

    // Metode som endrer lokalet
    @FXML
    private void actionEndreLokale(ActionEvent event) throws IOException, ClassNotFoundException, inputException {

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

        // Sjekker om input feltene er tomme
        try {
            if(lokaleID.isEmpty() || navn.isEmpty() ||
                    type.isEmpty()) {
                throw new inputException();
            }
        } catch (inputException ie) {
            alertbox.feil(inputException.emptyException());
        }

        // Validerer input-feltene til lokale
        try {
            if (!(lokaleID.matches("^[0-9]{1,30}$"))) {
                alertbox.feil("LokaleID må bestå av kun tall eller har for mange/for få tegn");
                return;
            } else if (!(navn.matches("^[A-ZÆØÅa-zæøå -]{2,30}$"))) {
                alertbox.feil("Navn har ugyldige tegn eller har for mange/for få tegn");
                return;
            } else if (!(type.matches("^[A-ZÆØÅa-zæøå0-9 -]{2,30}$"))) {
                alertbox.feil("Type har ugyldige tegn eller har for mange/for få tegn");
                return;
            }
        } catch (Exception e) {

        }

        Lokale lokale = new Lokale(lokaleID, navn, type, plasser);
        LokaleHåndtering lokaleHåndtering = new LokaleHåndtering();
        lokaleHåndtering.endreLokale(lokale);
        textfieldNavnLokale.clear();
        textfieldTypeLokale.clear();
        textfieldPlasserLokale.clear();

        try {
            // Henter det nåværende Array av Lokale
            LokaleSerialiser serialiser = new LokaleSerialiser();
            ArrayList<Lokale> liste = serialiser.lesArrayFraFil();

            System.out.println(liste);

            serialiser.skrivArrayTilFil(liste);

            // Lagerer på fil
            try {
                Stage stage = new Stage();
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
                File selectedFile = fileChooser.showOpenDialog(stage);
                String path = selectedFile.getPath();

                LokaleSerialiser lokaleSerialiser = new LokaleSerialiser();

                skrivTilFil skriv = new skrivTilCsv();
                skriv.skrivTilCsv(lokaleSerialiser.lesArrayFraFil(), path);
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            }
            // Slutt

        } catch (IOException ioe) {
           alertbox.feil(inputException.ioException());
           ioe.printStackTrace();
        } catch (ClassNotFoundException cnf) {

            alertbox.feil(klasseException.klasseException());
        }
    }

    // Metode som endrer kontaktperson
    @FXML
    private void actionEndreKontaktperson(ActionEvent event) throws IOException, ClassNotFoundException, inputException {
        Kontaktperson enKontaktperson = listKontaktperson.getSelectionModel().getSelectedItem();
        System.out.println("Du har trykket på endre kontaktperson");

        String personID = enKontaktperson.getPersonID();
        String fornavn = textfieldFornavnPerson.getText();
        String etternavn = textfieldEtternavnPerson.getText();
        String tlf = textfieldTlfPerson.getText();
        String epost = textfieldEpostPerson.getText();
        String nettside = textfieldNettsidePerson.getText();
        String virksomhet = textfieldVirksomhetPerson.getText();
        String opplysninger = textareaOpplysningerPerson.getText();

        // Sjekk om feltene er tomme
        try {
            if(fornavn.isEmpty() || etternavn.isEmpty() ||
                    tlf.isEmpty() || epost.isEmpty() ||
                    nettside.isEmpty() || virksomhet.isEmpty() ||
                    opplysninger.isEmpty()) {
                throw new inputException();
            }
        } catch (inputException ie) {
            alertbox.feil(inputException.emptyException());
        }

        // Validerer input-feltene til kontaktperson
        try {
            if (!(personID.matches("^[0-9]{1,10}$"))) {
                alertbox.feil("Person ID inneholder ugyldige tegn eller har for mange/for få tegn");
                return;
            } else if (!(fornavn.matches("^[A-ZÆØÅa-zæøå -]{2,20}$"))) {
                alertbox.feil("Fornavn inneholder ugyldige tegn eller har for mange/for få tegn");
                return;
            } else if (!(etternavn.matches("^[A-ZÆØÅa-zæøå -]{2,30}$"))) {
                alertbox.feil("Etternavn inneholder ugyldige tegn eller har for mange/for få tegn");
                return;
            } else if (!(tlf.matches("^[0-9]{8}$"))) {
                alertbox.feil("Telefon inneholder ugyldige tegn eller har for mange/for få tegn");
                return;
            } else if (!(epost.matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$"))) {
                alertbox.feil("Epost inneholder ugyldige tegn eller har for mange/for få tegn");
                return;
            } else if (!(nettside.matches("^[A-ZÆØÅa-zæøå0-9.-/]{4,30}"))) {
                alertbox.feil("Nettside inneholder ugyldige tegn eller har for mange/for få tegn");
                return;
            } else if (!(virksomhet.matches("^[A-Za-z ]{2,30}"))) {
                alertbox.feil("Virksomhet inneholder ugyldige tegn eller har for mange/for få tegn");
                return;
            } else if (!(opplysninger.matches("^[A-Za-z0-9 . ]{1,}$"))) {
                alertbox.feil("Opplysninger inneholder ugyldige tegn eller har for mange/for få tegn");
                return;
            }
        } catch (Exception e) {

        }

        Kontaktperson kontaktperson = new Kontaktperson(personID, fornavn, etternavn, tlf, epost, nettside, virksomhet, opplysninger);
        PersonHåndtering personHåndtering = new PersonHåndtering();
        personHåndtering.endrePerson(kontaktperson);
        textfieldFornavnPerson.clear();
        textfieldEtternavnPerson.clear();
        textfieldTlfPerson.clear();
        textfieldEpostPerson.clear();
        textfieldNettsidePerson.clear();
        textfieldVirksomhetPerson.clear();
        textareaOpplysningerPerson.clear();

        try {


            //Henter det nåværende Array av Kontaktperson
            PersonSerialiser serialiser = new PersonSerialiser();
            ArrayList<Kontaktperson> liste = serialiser.lesArrayFraFil();

            System.out.println(liste);

            serialiser.skrivArrayTilFil(liste);

            // Lagerer på fil
            try {
                Stage stage = new Stage();
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
                File selectedFile = fileChooser.showOpenDialog(stage);
                String path = selectedFile.getPath();

                PersonSerialiser personSerialiser = new PersonSerialiser();

                skrivTilFil skriv = new skrivTilCsv();
                skriv.skrivTilCsv(personSerialiser.lesArrayFraFil(), path);
            } catch (NullPointerException npe) {
                alertbox.feil(nullException.nullException());
            }
            // Slutt

        } catch (IOException ioe) {
            alertbox.feil(inputException.ioException());
        } catch (ClassNotFoundException cnf) {

            alertbox.feil(klasseException.klasseException());
        }
    }

    // Metode som endrer arrangement
    @FXML
    private void actionEndreArrangement(ActionEvent event) throws idException, inputException, NullPointerException {
        Arrangement etArrangement = listArrangement.getSelectionModel().getSelectedItem();
        System.out.println("Du har trykket på legg til arrangement");

        String arrangementID = etArrangement.getArrangementID();
        Lokale lokale = choiceLokale.getSelectionModel().getSelectedItem();
        Kontaktperson kontaktperson = choicePerson.getSelectionModel().getSelectedItem();
        String navn = textfieldNavnArr.getText();
        String artist = textfieldArtistArr.getText();
        String sted = textfieldStedArr.getText();
        LocalDate dato = datoDatoArr.getValue();
        String tidspunkt = textfieldTidspunktArr.getText();
        String beskrivelse = textareaBeskrivelse.getText();
        int billettPris = 0;
        int billettMaks = 0;

        // Sjekker at billettpris inneholder heltall
        try {
            billettPris = Integer.parseInt(textfieldBillettprisArr.getText());
        } catch (NumberFormatException nfe) {
            alertbox.feil("Billettpris er nødt til å være heltall.");
        }

        // Sjekker at maks billetter inneholder heltall
        try {
            billettMaks = Integer.parseInt(textfieldMaksBilletterArr.getText());
        } catch (NumberFormatException nfe) {
            alertbox.feil("Maks billetter må være heltatll.");
        }

        // Sjekk om menyene er lik NULL
        try {
            if(kontaktperson == null || lokale == null) {
                throw new NullPointerException();
            }
        } catch(NullPointerException npe) {
            alertbox.feil(inputException.nullexception());

        }

        // Sjekk om feltene er tomme
        try {
            if (navn.isEmpty() ||
                    artist.isEmpty() || sted.isEmpty() || beskrivelse.isEmpty()) {
                throw new inputException();
            }
        } catch (inputException ie) {
            alertbox.feil(inputException.emptyException());
        }

        // Validerer input-feltene til arrangement
        try {
            if(!(arrangementID.matches("^[0-9]{1,30}$"))) {
                alertbox.feil("ArrangementID inneholder ugyldige tegn eller har for mange/for få tegn");
                return;
            } else if(!(navn.matches("^[A-ZÆØÅa-zæøå :\\-]{2,30}$"))) {
                alertbox.feil("Navn inneholder ugyldige tegn eller har for mange/for få tegn");
                return;
            } else if(!(artist.matches("^[A-ZÆØÅa-zæøå ]{2,30}$"))) {
                alertbox.feil("Artist inneholder ugyldige tegn eller har for mange/for få tegn");
                return;
            } else if(!(sted.matches("^[A-ZÆØÅa-zæøå ]{2,30}$"))) {
                alertbox.feil("Sted inneholder ugyldige tegn eller har for mange/for få tegn");
                return;
            } else if(!(tidspunkt.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]"))) {
                alertbox.feil("Tid er i feil format");
                return;
            } else if(!(beskrivelse.matches("^[A-ZÆØÅa-zæøå0-9./ \\-]{1,}$"))) {
                alertbox.feil("Beskrivelse inneholder ugyldige tegn eller har for mange/for få tegn");
                return;
            }
        } catch (Exception e) {

        }

        Billett[] billett = new Billett[billettMaks];

        Arrangement arrangement = new Arrangement(arrangementID, kontaktperson, lokale, navn, artist, sted, dato, tidspunkt, beskrivelse, billettPris, billettMaks, billett);
        ArrangementHåndtering arrangementHåndtering = new ArrangementHåndtering();
        arrangementHåndtering.endreArrangement(arrangement);
        textfieldNavnArr.clear();
        textfieldArtistArr.clear();
        textfieldStedArr.clear();
        textfieldTidspunktArr.clear();
        textfieldBillettprisArr.clear();
        textfieldMaksBilletterArr.clear();
        textareaBeskrivelse.clear();

        try {
            //Henter det nåværende Array av Arrangementer
            ArrangementSerialiser serialiser = new ArrangementSerialiser();
            ArrayList<Arrangement> liste = serialiser.lesArrayFraFil();

            System.out.println(liste);

            serialiser.skrivArrayTilFil(liste);

            // Lagerer på fil
            try {
                Stage stage = new Stage();
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
                File selectedFile = fileChooser.showOpenDialog(stage);
                String path = selectedFile.getPath();

                ArrangementSerialiser arrangementSerialiser = new ArrangementSerialiser();

                skrivTilFil skriv = new skrivTilCsv();
                skriv.skrivTilCsv(arrangementSerialiser.lesArrayFraFil(), path);
            } catch (NullPointerException npe) {
                alertbox.feil(nullException.nullException());
            }
            // Slutt
        } catch (IOException ioe) {
            alertbox.feil(inputException.ioException());
        } catch (ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }
    }
}
