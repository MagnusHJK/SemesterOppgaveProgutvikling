package org.openjfx.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.alertbox;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleCellFactory;
import org.openjfx.logic.Person.Kontaktperson;

import java.io.IOException;
import java.util.stream.Collectors;



public class ControllerBlaGjennom {

    public void initialize() throws Exception{

        //Fyller ListView med lokaler (Bare typen på de)
        listLokale.setItems(Lokale.lagLokaleList());

        //Sier hva hver kolonne i Arrangement valget skal fylles med
        kolonneArrangementNavn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("navn"));
        kolonneArrangementType.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("type"));
        kolonneArrangementKjendis.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("artist"));
        kolonneArrangementPris.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("billettPris"));



    }

    @FXML
    private ListView<Lokale> listLokale;

    @FXML
    private TableView<Arrangement> tabellArrangement;

    @FXML
    private TableColumn<Arrangement, String> kolonneArrangementNavn;

    @FXML
    private TableColumn<Arrangement, String> kolonneArrangementType;

    @FXML
    private TableColumn<Arrangement, String> kolonneArrangementKjendis;

    @FXML
    private TableColumn<Arrangement, String> kolonneArrangementPris;

    @FXML
    private AnchorPane paneBlaGjennom;

    @FXML
    private Button btnKjopSide;


    //Click action for valg av lokale
    @FXML
    private void actionLokaleTrykk(MouseEvent event) {

        //Finner hvilken man trykker på
        Lokale lokale = listLokale.getSelectionModel().getSelectedItem();

        //Lager en ny ObservableList fra den gamle, men filtrert etter om den matcher lokale
        ObservableList<Arrangement> filtrert = Arrangement.lagArrangementListe()
                .stream()
                .filter(Arrangement -> Arrangement.getType().toString().equals(lokale.toString()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        //Populerer tabellen
        tabellArrangement.setItems(filtrert);
    }



    @FXML
    private void actionHjemSide(ActionEvent event) throws IOException {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/sceneMain.fxml"));
            paneBlaGjennom.getChildren().setAll(pane);
            System.out.println("Tar deg til Hjem siden.");
        } catch (IOException e) {
            alertbox.display("Feil","En feil oppstod");
        }
    }


    @FXML
    private void actionKjopSide(ActionEvent event) throws IOException {
            Arrangement valg = tabellArrangement.getSelectionModel().getSelectedItem();

            System.out.println("Du kjøpte " + valg.getNavn());

    }

}
