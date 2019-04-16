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
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonHåndtering;
import org.openjfx.logic.exceptions.idException;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.inputException;


import java.io.IOException;
import java.util.ArrayList;

public class ControllerAdminLeggTil {


    public void initialize() throws Exception {
        Element elementerListe = new Element();
        LokaleHåndtering lokaler = new LokaleHåndtering();
        PersonHåndtering personer = new PersonHåndtering();


        choiceLeggTillValg.setItems(elementerListe.lagElementListe());


        choiceTypeArr.setItems(lokaler.lagObservableList(Lokale.lagLokaleList()));
        choiceKontaktpersonArr.setItems(personer.lagObservableList(Kontaktperson.lagKontaktpersonListe()));

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
        String plasser = textfieldPlasserLokale.getText();



        // Sjekker om input feltene er tomme
        try {
            if(lokaleID.isEmpty() || navn.isEmpty() ||
            type.isEmpty() || plasser.isEmpty()) {
                throw new inputException();
            }
        } catch (inputException ie) {
            alertbox.display("Feilmelding",inputException.emptyException());
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
        String Epost = textfieldEpostKontakt.getText();
        String nettside = textfieldNettsideKontakt.getText();
        String virksomhet = textfieldVirksomhetKontakt.getText();
        String opplysninger = textareaOpplysningerKontakt.getText();

        // Sjekk om feltene er tomme
        try {
            if(fornavn.isEmpty() || etternavn.isEmpty() ||
            tlf.isEmpty() || Epost.isEmpty() ||
            nettside.isEmpty() || virksomhet.isEmpty() ||
            opplysninger.isEmpty()) {
                throw new inputException();
            }
        } catch (inputException ie) {
            alertbox.display("Feilmelding",inputException.emptyException());
        }



    }


    //Når brukeren trykker på "Legg til Arrangement" knapp
    @FXML
    private void actionLeggTilArrangement(ActionEvent event) throws idException, inputException{
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



        // Sjekk om feltene er tomme
        //TODO catche NumberFormatException
        try {
            if(arrangementID.isEmpty() || navn.isEmpty() ||
                    artist.isEmpty() || sted.isEmpty() || beskrivelse.isEmpty()) {
                throw new inputException();
            }
        } catch (inputException ie) {
            alertbox.display("Feilmelding",inputException.emptyException());
        }


        //TODO fikse exception
        try{
            billettPris = Integer.parseInt(textfieldBillettprisArr.getText());
            billettMaks = Integer.parseInt(textfieldMaksBilletterArr.getText());

        } catch(NumberFormatException nfe){
            alertbox.display("Feilmelding","Prisen og/eller antall biletter er nødt til å være heltall.");
        }


         Arrangement arrangement = new Arrangement(arrangementID, kontaktperson, lokale, navn, artist, sted, beskrivelse, billettPris, billettMaks);

        try{
            //Henter det nåværende Array av Arrangementer og legger det nye Arrangementet inn
            ArrangementSerialiser Arrangement = new ArrangementSerialiser();
            ArrayList<Arrangement> liste = Arrangement.lesArrayFraFil();

            liste.add(arrangement);
            System.out.println(liste);

            Arrangement.skrivArrayTilFil(liste);
        } catch(IOException ioe){
            ioe.printStackTrace();
        }catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
        }

    }

}
