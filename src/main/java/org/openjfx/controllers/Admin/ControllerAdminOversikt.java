package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementHåndtering;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Billett.Billett;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleHåndtering;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonHåndtering;
import org.openjfx.logic.Person.PersonSerialiser;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ControllerAdminOversikt {

    public void initialize(){
        KolonneArrangementID.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("arrangementID"));
        KolonneArrangementKontaktperson.setCellValueFactory(new PropertyValueFactory<Arrangement, Kontaktperson>("kontaktperson"));
        KolonneArrangementLokale.setCellValueFactory(new PropertyValueFactory<Arrangement, Lokale>("type"));
        KolonneArrangementNavn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("navn"));
        KolonneArrangementArtist.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("artist"));
        KolonneArrangementSted.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("sted"));
        KolonneArrangementDato.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("dato"));
        KolonneArrangementTidspunkt.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("tidspunkt"));
        KolonneArrangementPris.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("billettPris"));
        KolonneArrangementBillettMaks.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("billettMaks"));
        KolonneArrangementSolgte.setCellValueFactory(new PropertyValueFactory<Arrangement, Billett[]>("salg"));


        KolonneLokalerID.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("lokaleID"));
        KolonneLokalerNavn.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("navn"));
        KolonneLokalerType.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("type"));
        KolonneLokalerPlasser.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("antallPlasser"));



    }


    @FXML
    private TableView<Arrangement> tabellArrangementer;

    @FXML
    private TableColumn<Arrangement, String> KolonneArrangementID;

    @FXML
    private TableColumn<Arrangement, Kontaktperson> KolonneArrangementKontaktperson;

    @FXML
    private TableColumn<Arrangement, Lokale> KolonneArrangementLokale;

    @FXML
    private TableColumn<Arrangement, String> KolonneArrangementNavn;

    @FXML
    private TableColumn<Arrangement, String> KolonneArrangementArtist;

    @FXML
    private TableColumn<Arrangement, String> KolonneArrangementSted;

    @FXML
    private TableColumn<Arrangement, String> KolonneArrangementDato;

    @FXML
    private TableColumn<Arrangement, String> KolonneArrangementTidspunkt;

    @FXML
    private TableColumn<Arrangement, String> KolonneArrangementPris;

    @FXML
    private TableColumn<Arrangement, String> KolonneArrangementBillettMaks;

    @FXML
    private TableColumn<Arrangement, Billett[]> KolonneArrangementSolgte;



    @FXML
    private TableView<Lokale> tabellLokaler;


    @FXML
    private TableColumn<Arrangement, String> KolonneLokalerID;

    @FXML
    private TableColumn<Arrangement, String> KolonneLokalerNavn;

    @FXML
    private TableColumn<Arrangement, String> KolonneLokalerType;

    @FXML
    private TableColumn<Arrangement, String> KolonneLokalerPlasser;





    @FXML
    private void actionOppdater(ActionEvent event)throws Exception{
        ArrangementSerialiser serialiserArr = new ArrangementSerialiser();
        ArrangementHåndtering håndteringArr = new ArrangementHåndtering();

        LokaleSerialiser serialiserLok = new LokaleSerialiser();
        LokaleHåndtering håndteringLok = new LokaleHåndtering();

        PersonSerialiser serialiserPer = new PersonSerialiser();
        PersonHåndtering håndteringPer = new PersonHåndtering();


        try{
            tabellArrangementer.setItems(håndteringArr.lagObservableList(serialiserArr.lesArrayFraFil()));
            tabellLokaler.setItems(håndteringLok.lagObservableList(serialiserLok.lesArrayFraFil()));
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }

}
