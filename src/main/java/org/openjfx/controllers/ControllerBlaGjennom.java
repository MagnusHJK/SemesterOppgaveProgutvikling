package org.openjfx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementHåndtering;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleCellFactory;
import org.openjfx.logic.Lokale.LokaleHåndtering;


import java.io.IOException;


public class ControllerBlaGjennom {

    public void initialize() throws Exception{
        LokaleHåndtering lokaler = new LokaleHåndtering();

        //Fyller ListView med lokaler (Bare typen på de)
        listLokale.setCellFactory(new LokaleCellFactory());
        listLokale.setItems(lokaler.lagObservableList(Lokale.lagLokaleList()));

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
    private Label lblArrangementDetaljer;

    @FXML
    private AnchorPane paneBlaGjennom;

    @FXML
    private Button btnKjopSide;


    //Click action for valg av lokale
    @FXML
    private void actionLokaleTrykk(MouseEvent event) {

        //Finner hvilket lokale man trykker på
        Lokale lokale = listLokale.getSelectionModel().getSelectedItem();

        ArrangementHåndtering filter = new ArrangementHåndtering();

        //Lager filtrert liste over Arrangement som matcher Lokaler
        filter.filtrerArrangementer(Arrangement.lagArrangementListe(),lokale);


        //Populerer tabellen TODO del opp
        tabellArrangement.setItems(filter.filtrerArrangementer(Arrangement.lagArrangementListe(),lokale));

    }

    @FXML
    private void actionArrangementTrykk(MouseEvent event){
        Arrangement arrangement = tabellArrangement.getSelectionModel().getSelectedItem();
        ArrangementHåndtering filter = new ArrangementHåndtering();



        lblArrangementDetaljer.setText(filter.filtrerArrangementDetaljer(Arrangement.lagArrangementListe(), arrangement));

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
