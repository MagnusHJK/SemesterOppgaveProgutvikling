package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.logic.Admin.Element;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Arrangement.ArrangementValidering;
import org.openjfx.logic.Billett.Billett;
import org.openjfx.logic.Filhåndtering.skrivTilCsv;
import org.openjfx.logic.Filhåndtering.skrivTilFil;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleHåndtering;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Lokale.LokaleValidering;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.KontaktpersonValidering;
import org.openjfx.logic.Person.PersonHåndtering;
import org.openjfx.logic.Person.PersonSerialiser;
import org.openjfx.logic.exceptions.idException;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.inputException;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ControllerAdminLeggTil {


    public void initialize() throws Exception {
        Element elementerListe = new Element();

        LokaleHåndtering lokaler = new LokaleHåndtering();
        LokaleSerialiser lokaleSerialiser = new LokaleSerialiser();

        PersonHåndtering personer = new PersonHåndtering();
        // midlertidig
       // Kontaktperson.lagKontaktpersonListe();
        PersonSerialiser personSerialiser = new PersonSerialiser();
        //Kontaktperson.lagKontaktpersonListe();


        choiceLeggTillValg.setItems(elementerListe.lagElementListe());

        choiceTypeArr.setItems(lokaler.lagObservableList(lokaleSerialiser.lesArrayFraFil()));

        choiceKontaktpersonArr.setItems(personer.lagObservableList(personSerialiser.lesArrayFraFil()));


    }


    //Legg til
    @FXML
    private Tab tabLeggTil;

    @FXML
    private ChoiceBox<String> choiceLeggTillValg;

    @FXML
    private Button btnLeggTilValg;




    //Arrangement
    @FXML
    private TextField textfieldArrangementID;

    @FXML
    private ChoiceBox<Kontaktperson> choiceKontaktpersonArr;

    @FXML
    private ChoiceBox<Lokale> choiceTypeArr;

    @FXML
    private TextField textfieldNavnArr;

    @FXML
    private TextField textfieldArtistArr;

    @FXML
    private TextField textfieldStedArr;

    @FXML
    private DatePicker dateDatoArr;

    @FXML
    private TextField textfieldTidspunktArr;

    @FXML
    private TextField textfieldBillettprisArr;

    @FXML
    private TextField textfieldMaksBilletterArr;

    @FXML
    private TextArea textfieldBeskrivelseArr;

    @FXML
    private Pane paneArrangement;



    //Lokale
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


    //Kontaktperson
    @FXML
    private Pane paneKontaktperson;



    @FXML
    private TextField textfieldKontaktpersonID;

    @FXML
    private TextField textfieldFornavnKontakt;

    @FXML
    private TextField textfieldEtternavnKontakt;

    @FXML
    private TextField textfieldTelefonKontakt;

    @FXML
    private TextField textfieldEpostKontakt;

    @FXML
    private TextField textfieldNettsideKontakt;

    @FXML
    private TextField textfieldVirksomhetKontakt;

    @FXML
    private TextArea textareaOpplysningerKontakt;


    //Når brukeren velger kategori for elementet
    @FXML
    private void actionLeggTilValg(ActionEvent event){
        String valg = choiceLeggTillValg.getSelectionModel().getSelectedItem();



        //TODO Bytte til switch??
        if(valg.equals("Lokale")){
            paneLokale.setVisible(true);
            paneKontaktperson.setVisible(false);
            paneArrangement.setVisible(false);

        }else if(valg.equals("Kontaktperson")){
            paneLokale.setVisible(false);
            paneKontaktperson.setVisible(true);
            paneArrangement.setVisible(false);


        }else if(valg.equals("Arrangement")){
            paneLokale.setVisible(false);
            paneKontaktperson.setVisible(false);
            paneArrangement.setVisible(true);
        }else{

        }

    }


    //Når brukeren trykker på "Legg til Lokale" knapp
    @FXML
    private void actionLeggTilLokale(ActionEvent event) throws IOException, ClassNotFoundException, inputException{
        System.out.println("Du har trykket på legg til lokale");

        String lokaleID = textfieldLokaleID.getText();
        String navn = textfieldNavnLokale.getText();
        String type = textfieldTypeLokale.getText();
        int plasser = 0;



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
                alertbox.feil("LokaleID må bestå av kun tall");
                return;
            } else if (!(navn.matches("^[A-ZÆØÅa-zæøå -]{2,30}$"))) {
                alertbox.feil("Navn har ugyldige tegn. Gyldige tegn er: A-Å, a-å, -");
                return;
            } else if (!(type.matches("^[A-ZÆØÅa-zæøå0-9 -]{2,30}$"))) {
                alertbox.feil("Type har ugyldige tegn. Gyldige tegn er: A-Å, a-å, 0-9, -");
                return;
            }
        } catch (Exception e) {

        }

        //Prøver å konvertere plasser til int
        try{
            plasser = Integer.parseInt(textfieldPlasserLokale.getText());

        } catch(NumberFormatException nfe){
            alertbox.feil("Antall plasser er nødt til å være heltall.");
        }




        Lokale lokale = new Lokale(lokaleID, navn, type, plasser);
        textfieldLokaleID.clear();
        textfieldNavnLokale.clear();
        textfieldTypeLokale.clear();
        textfieldPlasserLokale.clear();

        try{


            //Henter det nåværende Array av Arrangementer og legger det nye Arrangementet inn
            LokaleSerialiser serialiser = new LokaleSerialiser();
            ArrayList<Lokale> liste = serialiser.lesArrayFraFil();

            liste.add(lokale);
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

        } catch(IOException ioe){
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
        }

    }




    //Når brukeren trykker på "Legg til Kontakt person" knapp
    //TODO Exceptions
    @FXML
    private void actionLeggTilKontaktperson(ActionEvent event) throws inputException{
        System.out.println("Du har trykket på legg til kontaktperson");

        String personID = textfieldKontaktpersonID.getText();
        String fornavn = textfieldFornavnKontakt.getText();
        String etternavn = textfieldEtternavnKontakt.getText();
        String tlf = textfieldTelefonKontakt.getText();
        String epost = textfieldEpostKontakt.getText();
        String nettside = textfieldNettsideKontakt.getText();
        String virksomhet = textfieldVirksomhetKontakt.getText();
        String opplysninger = textareaOpplysningerKontakt.getText();


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
                alertbox.feil("Person ID inneholder ugyldige tegn.");
                return;
            } else if (!(fornavn.matches("^[A-ZÆØÅa-zæøå -]{2,20}$"))) {
                alertbox.feil("Fornavn inneholder ugyldige tegn.");
                return;
            } else if (!(etternavn.matches("^[A-ZÆØÅa-zæøå -]{2,30}$"))) {
                alertbox.feil("Etternavn inneholder ugyldige tegn.");
                return;
            } else if (!(tlf.matches("^[0-9]{8}$"))) {
                alertbox.feil("Telefon inneholder ugyldige tegn.");
                return;
            } else if (!(epost.matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$"))) {
                alertbox.feil("Epost inneholder ugyldige tegn.");
                return;
            } else if (!(nettside.matches("^[A-ZÆØÅa-zæøå0-9.-/]{4,30}"))) {
                alertbox.feil("Nettside inneholder ugyldige tegn.");
                return;
            } else if (!(virksomhet.matches("^[A-Za-z ]{2,30}"))) {
                alertbox.feil("Virksomhet inneholder ugyldige tegn.");
                return;
            } else if (!(opplysninger.matches("^[A-Za-z0-9. ]{1,}$"))) {
                alertbox.feil("Opplysninger inneholder ugyldige tegn.");
                return;
            }
        } catch (Exception e) {

        }

        Kontaktperson kontaktperson = new Kontaktperson(personID, fornavn, etternavn, tlf, epost, nettside, virksomhet, opplysninger);
        textfieldKontaktpersonID.clear();
        textfieldFornavnKontakt.clear();
        textfieldEtternavnKontakt.clear();
        textfieldTelefonKontakt.clear();
        textfieldEpostKontakt.clear();
        textfieldNettsideKontakt.clear();
        textfieldVirksomhetKontakt.clear();
        textareaOpplysningerKontakt.clear();

        try {
            PersonSerialiser serialiser = new PersonSerialiser();
            ArrayList<Kontaktperson> liste = serialiser.lesArrayFraFil();

            liste.add(kontaktperson);
            System.out.println(liste);

            serialiser.skrivArrayTilFil(liste);

            // Lagerer på fil
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            String path = selectedFile.getPath();

            PersonSerialiser personSerialiser = new PersonSerialiser();

            skrivTilFil skriv = new skrivTilCsv();
            skriv.PersonTilCsv(personSerialiser.lesArrayFraFil(),path);
            // Slutt

        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
        }

    }





    //Når brukeren trykker på "Legg til Arrangement" knapp
    @FXML
    private void actionLeggTilArrangement(ActionEvent event) throws idException, inputException, NullPointerException{
        System.out.println("Du har trykket på legg til arrangement");
        String arrangementID = textfieldArrangementID.getText();
        Kontaktperson kontaktperson = choiceKontaktpersonArr.getSelectionModel().getSelectedItem();
        Lokale lokale = choiceTypeArr.getSelectionModel().getSelectedItem();
        String navn = textfieldNavnArr.getText();
        String artist = textfieldArtistArr.getText();
        String sted = textfieldStedArr.getText();
        LocalDate dato = dateDatoArr.getValue();
        String tidspunkt = textfieldTidspunktArr.getText();
        String beskrivelse = textfieldBeskrivelseArr.getText();
        int billettPris = 0;
        int billettMaks = 0;
        boolean ok = true;



        // Sjekk om feltene er tomme
        try {
            if(arrangementID.isEmpty() || navn.isEmpty() ||
                    artist.isEmpty() || sted.isEmpty() || beskrivelse.isEmpty()) {
                ok = false;
                throw new inputException();

            }

        } catch (inputException ie) {
            alertbox.feil(inputException.emptyException());

        }

        // Validerer input-feltene til arrangement
        try {
            if(!(arrangementID.matches("^[0-9]{1,30}$"))) {
                alertbox.feil("ArrangementID inneholder ugyldige tegn.");
                return;
            } else if(!(navn.matches("^[A-ZÆØÅa-zæøå :\\-]{2,30}$"))) {
                alertbox.feil("Navn inneholder ugyldige tegn.");
                return;
            } else if(!(artist.matches("^[A-ZÆØÅa-zæøå ]{2,30}$"))) {
                alertbox.feil("Artist inneholder ugyldige tegn.");
                return;
            } else if(!(sted.matches("^[A-ZÆØÅa-zæøå ]{2,30}$"))) {
                alertbox.feil("Sted inneholder ugyldige tegn.");
                return;
            } else if(!(tidspunkt.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]"))) {
                alertbox.feil("Tid er i feil format.");
                return;
            } else if(!(beskrivelse.matches("^[A-ZÆØÅa-zæøå0-9./ \\-]{1,}$"))) {
                alertbox.feil("Beskrivelse inneholder ugyldige tegn.");
                return;
            }
        } catch (Exception e) {
            
        }

        // Sjekk om menyene er lik NULL
        try {
            if(kontaktperson == null || lokale == null) {
                ok = false;
                throw new NullPointerException();
            }
        } catch(NullPointerException npe) {
            alertbox.feil(inputException.nullexception());

        }

        // Sjekker om input feltene inneholder tall der det trengs
        try{
            billettPris = Integer.parseInt(textfieldBillettprisArr.getText());
            billettMaks = Integer.parseInt(textfieldMaksBilletterArr.getText());
            //ok = false;
           // throw new inputException();
        } catch(NumberFormatException nfe){
            alertbox.feil(inputException.intException());

        }

        if(!ok) {

        } else {
            Billett[] billett = new Billett[billettMaks];

            Arrangement arrangement = new Arrangement(arrangementID, kontaktperson, lokale, navn, artist, sted, dato, tidspunkt, beskrivelse, billettPris, billettMaks, billett);
            textfieldArrangementID.clear();
            textfieldNavnArr.clear();
            textfieldArtistArr.clear();
            textfieldStedArr.clear();
            textfieldTidspunktArr.clear();
            textfieldBillettprisArr.clear();
            textfieldMaksBilletterArr.clear();
            textfieldBeskrivelseArr.clear();

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
                skriv.ArrangementTilCsv(arrangementSerialiser.lesArrayFraFil(),path);
                // Slutt


            } catch (IOException | ClassNotFoundException cnf) {
                cnf.printStackTrace();
            }


        }


    }
}
