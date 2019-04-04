package org.openjfx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.openjfx.logic.Admin.Element;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Arrangement.ArrangementValidering;
import org.openjfx.logic.Lokale.Lokale;


import java.io.IOException;
import java.util.ArrayList;

public class ControllerAdmin {


    public void initialize() {
        Element elementerListe = new Element();
        choiceLeggTillValg.setItems(elementerListe.lagElementListe());
        choiceTypeArr.setItems(Lokale.lagLokaleList());

    }


    @FXML
    private AnchorPane paneAdmin;

    @FXML
    private Tab tabLeggTil;

    @FXML
    private ChoiceBox<String> choiceLeggTillValg;

    @FXML
    private Button btnLeggTilValg;

    @FXML
    private ChoiceBox choiceKontaktpersonArr;

    @FXML
    private ChoiceBox<Lokale> choiceTypeArr;

    @FXML
    private TextField textfieldNavnArr;

    @FXML
    private TextField textfieldArtistArr;

    @FXML
    private TextField textfieldStedArr;

    @FXML
    private TextField textfieldBillettpris;

    @FXML
    private TextField textfieldMaksBilletterArr;

    @FXML
    private TextArea textfieldBeskrivelseArr;

    @FXML
    private Pane paneArrangement;


    @FXML
    private Pane paneLokale;

    @FXML
    private Pane paneKontaktperson;

    @FXML
    private Tab tabEndre;

    @FXML
    private Tab tabSlett;

    @FXML
    private Tab tabLagreTilFil;

    @FXML
    private Button btnHjemSide;

    @FXML
    private Button btnTest;


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
        }

    }


    //Når brukeren trykker på "Legg til Lokale" knapp
    @FXML
    private void actionLeggTilLokale(ActionEvent event) throws IOException, ClassNotFoundException{
        System.out.println("Du har trykket på legg til lokale");

    }


    //Når brukeren trykker på "Legg til Kontakt person" knapp
    @FXML
    private void actionLeggTilKontaktperson(ActionEvent event){
        System.out.println("Du har trykket på legg til kontaktperson");

    }


    //Når brukeren trykker på "Legg til Arrangement" knapp
    @FXML
    private void actionLeggTilArrangement(ActionEvent event) {
        System.out.println("Du har trykket på legg til arrangement");
        //Kontaktperson kontaktperson = choiceKontaktpersonArr.getSelectionModel().getSelectedItem();
        Lokale lokale = choiceTypeArr.getSelectionModel().getSelectedItem();
        String navn = textfieldNavnArr.getText();
        String artist = textfieldArtistArr.getText();
        String sted = textfieldStedArr.getText();
        String beskrivelse = textfieldBeskrivelseArr.getText();
        int billettPris = 0;
        int billettMaks = 0;



        //TODO fikse exception
        try{
            billettPris = Integer.parseInt(textfieldBillettpris.getText());
            billettMaks = Integer.parseInt(textfieldMaksBilletterArr.getText());
        }catch(NumberFormatException nfe){
            nfe.printStackTrace();
        }


        // Arrangement arrangement = new Arrangement(kontaktperson, lokale, navn, artist, sted, beskrivelse, billettPris, billettMaks);


        try{
            //Henter det nåværende Array av Arrangementer og legger det nye Arrangementet inn
            ArrangementSerialiser Arrangement = new ArrangementSerialiser();
            ArrayList<Arrangement> liste = Arrangement.lesArrayFraFil();

            //liste.add(arrangement);

            Arrangement.skrivArrayTilFil(liste);
        } catch(IOException ioe){
            ioe.printStackTrace();
        }catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
        }

    }



    @FXML
    private void actionHjemSide(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/sceneMain.fxml"));
        paneAdmin.getChildren().setAll(pane);
        System.out.println("Tar deg til Hjem siden.");
    }

}
