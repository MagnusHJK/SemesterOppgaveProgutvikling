package org.openjfx.controllers.Butikk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementHåndtering;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonHåndtering;
import org.openjfx.logic.Person.PersonSerialiser;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleCellFactory;
import org.openjfx.logic.Lokale.LokaleHåndtering;
import org.openjfx.logic.exceptions.valgException;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class ControllerBlaGjennom {

    public void initialize() throws Exception{
        LokaleHåndtering lokaler = new LokaleHåndtering();
        LokaleSerialiser serialiser = new LokaleSerialiser();

        //Fyller ListView med lokaler (Bare typen på de)
        listLokale.setCellFactory(new LokaleCellFactory());
        listLokale.setItems(lokaler.lagObservableList(serialiser.lesArrayFraFil()));

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
    private Label lblKontaktpersonDetaljer;

    @FXML
    private AnchorPane paneBlaGjennom;

    @FXML
    private Button btnKjopSide;


    //Click action for valg av lokale
    @FXML
    private void actionLokaleTrykk(MouseEvent event) {

        //Finner hvilket lokale man trykker på
        Lokale lokale = listLokale.getSelectionModel().getSelectedItem();

        ArrangementHåndtering filterArr = new ArrangementHåndtering();
        ArrangementSerialiser serialiserArr = new ArrangementSerialiser();


        //Populerer tabellen TODO del opp
        try{
            tabellArrangement.setItems(filterArr.filtrerArrangementer(serialiserArr.lesArrayFraFil(),lokale));
        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch(ClassNotFoundException cnf){
            cnf.printStackTrace();
        }

    }


    @FXML
    private void actionArrangementTrykk(MouseEvent event){
        Arrangement arrangement = tabellArrangement.getSelectionModel().getSelectedItem();
        ArrangementHåndtering filterArr = new ArrangementHåndtering();
        ArrangementSerialiser serialiserArr = new ArrangementSerialiser();


        //Filtrerer riktig arrangement og setter teksten på labelen til å være informasjon om arrangementet
        //Velger kontaktperson fra samme arrangement og setter labelen til informasjon om han/henne
        try{
            lblArrangementDetaljer.setText(filterArr.filtrerArrangementDetaljer(serialiserArr.lesArrayFraFil(), arrangement));
            lblKontaktpersonDetaljer.setText(arrangement.getKontaktperson().toString());
        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch(ClassNotFoundException cnf){
            cnf.printStackTrace();
        }


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
            try {
                Arrangement valg = tabellArrangement.getSelectionModel().getSelectedItem();
                alertbox.display("Fullført","Du kjøpte:" + valg.getNavn());
            } catch (RuntimeException e) {
                alertbox.display("En feil oppstod!",valgException.valgException());
            }
    }

}
