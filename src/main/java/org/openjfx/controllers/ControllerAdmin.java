package org.openjfx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.openjfx.logic.Admin.Element;
import org.openjfx.logic.Lokale.Lokale;

import java.io.IOException;

public class ControllerAdmin {


    public void initialize() {
        choiceLeggTillValg.setItems(Element.lagElementListe());


    }


    @FXML
    private AnchorPane paneAdmin;

    @FXML
    private Tab tabLeggTil;

    @FXML
    private ChoiceBox choiceLeggTillValg;

    @FXML
    private Button btnLeggTilValg;

    @FXML
    private Pane paneArrangement;

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
        String valg = choiceLeggTillValg.getSelectionModel().getSelectedItem().toString();

        if(valg.equals("Lokale")){
            paneArrangement.setVisible(false);

        }else if(valg.equals("Kontaktperson")){
            paneArrangement.setVisible(false);

        }else if(valg.equals("Arrangement")){
            paneArrangement.setVisible(true);
        }

    }


    //Når brukeren trykker på "Legg til Lokale" knapp
    @FXML
    private void actionLeggTilLokale(ActionEvent event){
        System.out.println("Du har trykket på legg til lokale");
    }


    //Når brukeren trykker på "Legg til Kontakt person" knapp
    @FXML
    private void actionLeggTilKontaktperson(ActionEvent event){
        System.out.println("Du har trykket på legg til kontaktperson");

    }


    //Når brukeren trykker på "Legg til Arrangement" knapp
    @FXML
    private void actionLeggTilArrangement(ActionEvent event){
        System.out.println("Du har trykket på legg til arrangement");

    }



    @FXML
    private void actionHjemSide(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/sceneMain.fxml"));
        paneAdmin.getChildren().setAll(pane);
        System.out.println("Tar deg til Hjem siden.");
    }

}
