package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import org.openjfx.logic.Admin.Element;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleHåndtering;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonHåndtering;
import org.openjfx.logic.Person.PersonSerialiser;
import org.openjfx.logic.exceptions.idException;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.inputException;


import java.io.IOException;
import java.util.ArrayList;

public class ControllerAdminLeggTil {


    public void initialize() throws Exception {
        Element elementerListe = new Element();

        LokaleHåndtering lokaler = new LokaleHåndtering();
        LokaleSerialiser lokaleSerialiser = new LokaleSerialiser();

        PersonHåndtering personer = new PersonHåndtering();
        // midlertidig
        Kontaktperson.lagKontaktpersonListe();
        PersonSerialiser personSerialiser = new PersonSerialiser();
        Kontaktperson.lagKontaktpersonListe();


        choiceLeggTillValg.setItems(elementerListe.lagElementListe());

         choiceTypeArr.setItems(lokaler.lagObservableList(lokaleSerialiser.lesArrayFraFil()));

        //TODO fikse serialisering
       // choiceKontaktpersonArr.setItems(personer.lagObservableList(personSerialiser.lesArrayFraFil()));


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
        //Element elemValg = new Element();
        String valg = choiceLeggTillValg.getSelectionModel().getSelectedItem();

        //elemValg.elementValg(valg);


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
            alertbox.display("Feilmelding",inputException.emptyException());
        }

        //Prøver å konvertere plasser til int
        try{
            plasser = Integer.parseInt(textfieldPlasserLokale.getText());

        } catch(NumberFormatException nfe){
            alertbox.display("Feilmelding","Antall plasser er nødt til å være heltall.");
        }


        Lokale lokale = new Lokale(lokaleID, navn, type, plasser);

        try{
            //Henter det nåværende Array av Arrangementer og legger det nye Arrangementet inn
            LokaleSerialiser serialiser = new LokaleSerialiser();
            ArrayList<Lokale> liste = serialiser.lesArrayFraFil();

            liste.add(lokale);
            System.out.println(liste);

            serialiser.skrivArrayTilFil(liste);

        } catch(IOException ioe){
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
        }

    }




    //Når brukeren trykker på "Legg til Kontakt person" knapp
    @FXML
    private void actionLeggTilKontaktperson(ActionEvent event) throws inputException{
        System.out.println("Du har trykket på legg til kontaktperson");

        String kontaktpersonID = textfieldKontaktpersonID.getText();
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
            alertbox.display("Feilmelding",inputException.emptyException());
        }

        Kontaktperson kontaktperson = new Kontaktperson(fornavn, etternavn, tlf, kontaktpersonID, epost, nettside, virksomhet, opplysninger);

        try {
            PersonSerialiser serialiser = new PersonSerialiser();
            ArrayList<Kontaktperson> liste = serialiser.lesArrayFraFil();

            liste.add(kontaktperson);
            System.out.println(liste);

            serialiser.skrivArrayTilFil(liste);

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
            alertbox.display("Feilmelding",inputException.emptyException());

        }

        // Sjekk om menyene er lik NULL
        try {
            if(kontaktperson == null || lokale == null) {
                ok = false;
                throw new NullPointerException();
            }
        } catch(NullPointerException npe) {
            alertbox.display("Feilmeldng", inputException.nullexception());

        }

        // Sjekker om input feltene inneholder tall der det trengs
        try{
            billettPris = Integer.parseInt(textfieldBillettprisArr.getText());
            billettMaks = Integer.parseInt(textfieldMaksBilletterArr.getText());
            ok = false;
            throw new inputException();
        } catch(NumberFormatException nfe){
            alertbox.display("Feilmelding",inputException.intException());

        }

        if(!ok) {

        } else {
            Arrangement arrangement = new Arrangement(arrangementID, kontaktperson, lokale, navn, artist, sted, beskrivelse, billettPris, billettMaks);

            try {
                //Henter det nåværende Array av Arrangementer og legger det nye Arrangementet inn
                ArrangementSerialiser serialiser = new ArrangementSerialiser();
                ArrayList<Arrangement> liste = serialiser.lesArrayFraFil();

                liste.add(arrangement);
                System.out.println(liste);

                serialiser.skrivArrayTilFil(liste);

            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (ClassNotFoundException cnf) {
                cnf.printStackTrace();
            }
        }
    }

}
