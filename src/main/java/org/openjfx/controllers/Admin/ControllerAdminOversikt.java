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
import org.openjfx.logic.Billett.BillettHåndtering;
import org.openjfx.logic.Billett.BillettSerialiser;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleHåndtering;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonHåndtering;
import org.openjfx.logic.Person.PersonSerialiser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

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
        KolonneArrangementSolgte.setCellValueFactory(cellData -> cellData.getValue().getSalgAntall());


        KolonneLokalerID.setCellValueFactory(new PropertyValueFactory<Lokale, String>("lokaleID"));
        KolonneLokalerNavn.setCellValueFactory(new PropertyValueFactory<Lokale, String>("navn"));
        KolonneLokalerType.setCellValueFactory(new PropertyValueFactory<Lokale, String>("type"));
        KolonneLokalerPlasser.setCellValueFactory(new PropertyValueFactory<Lokale, String>("antallPlasser"));

        KolonneKontaktpersonID.setCellValueFactory(new PropertyValueFactory<Kontaktperson, String>("personID"));
        KolonneKontaktpersonFornavn.setCellValueFactory(new PropertyValueFactory<Kontaktperson, String>("fornavn"));
        KolonneKontaktpersonEtternavn.setCellValueFactory(new PropertyValueFactory<Kontaktperson, String>("etternavn"));
        KolonneKontaktpersonTlf.setCellValueFactory(new PropertyValueFactory<Kontaktperson, String>("telefon"));
        KolonneKontaktpersonEpost.setCellValueFactory(new PropertyValueFactory<Kontaktperson, String>("epost"));
        KolonneKontaktpersonNettside.setCellValueFactory(new PropertyValueFactory<Kontaktperson, String>("nettside"));
        KolonneKontaktpersonVirksomhet.setCellValueFactory(new PropertyValueFactory<Kontaktperson, String>("virksomhet"));


        KolonneBilletterArrangement.setCellValueFactory(new PropertyValueFactory<Billett, Arrangement>("arrangement"));
        KolonneBilletterPlassnummer.setCellValueFactory(new PropertyValueFactory<Billett, Billett>("plassnummer"));
        KolonneBilletterLokale.setCellValueFactory(new PropertyValueFactory<Billett, Lokale>("lokale"));
        KolonneBilletterDato.setCellValueFactory(new PropertyValueFactory<Billett, LocalDate>("dato"));
        KolonneBilletterTidspunkt.setCellValueFactory(new PropertyValueFactory<Billett, String>("tidspunkt"));
        KolonneBilletterTelefonnr.setCellValueFactory(new PropertyValueFactory<Billett, String>("telefonnr"));
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
    private TableColumn<Arrangement, Integer> KolonneArrangementSolgte;



    @FXML
    private TableView<Lokale> tabellLokaler;


    @FXML
    private TableColumn<Lokale, String> KolonneLokalerID;

    @FXML
    private TableColumn<Lokale, String> KolonneLokalerNavn;

    @FXML
    private TableColumn<Lokale, String> KolonneLokalerType;

    @FXML
    private TableColumn<Lokale, String> KolonneLokalerPlasser;



    @FXML
    private TableView<Kontaktperson> tabellKontaktpersoner;


    @FXML
    private TableColumn<Kontaktperson, String> KolonneKontaktpersonID;

    @FXML
    private TableColumn<Kontaktperson, String> KolonneKontaktpersonFornavn;

    @FXML
    private TableColumn<Kontaktperson, String> KolonneKontaktpersonEtternavn;

    @FXML
    private TableColumn<Kontaktperson, String> KolonneKontaktpersonTlf;

    @FXML
    private TableColumn<Kontaktperson, String> KolonneKontaktpersonEpost;

    @FXML
    private TableColumn<Kontaktperson, String> KolonneKontaktpersonNettside;

    @FXML
    private TableColumn<Kontaktperson, String> KolonneKontaktpersonVirksomhet;




    @FXML
    private TableView<Billett> tabellBilletter;

    @FXML
    private TableColumn<Billett, Arrangement> KolonneBilletterArrangement;

    @FXML
    private TableColumn<Billett, Billett> KolonneBilletterPlassnummer;

    @FXML
    private TableColumn<Billett, Lokale> KolonneBilletterLokale;

    @FXML
    private TableColumn<Billett, LocalDate> KolonneBilletterDato;

    @FXML
    private TableColumn<Billett, String> KolonneBilletterTidspunkt;

    @FXML
    private TableColumn<Billett, String> KolonneBilletterTelefonnr;




    @FXML
    private void actionOppdater(ActionEvent event)throws Exception{
        ArrangementSerialiser serialiserArr = new ArrangementSerialiser();
        ArrangementHåndtering håndteringArr = new ArrangementHåndtering();

        LokaleSerialiser serialiserLok = new LokaleSerialiser();
        LokaleHåndtering håndteringLok = new LokaleHåndtering();

        PersonSerialiser serialiserPer = new PersonSerialiser();
        PersonHåndtering håndteringPer = new PersonHåndtering();

        BillettSerialiser serialiserBill = new BillettSerialiser();
        BillettHåndtering håndteringBill = new BillettHåndtering();


        try{
            //Deserialiserer databasen, lager ObservableLister av det og legger det i tabellene
            tabellArrangementer.setItems(håndteringArr.lagObservableList(serialiserArr.lesArrayFraFil()));
            tabellLokaler.setItems(håndteringLok.lagObservableList(serialiserLok.lesArrayFraFil()));
            tabellKontaktpersoner.setItems(håndteringPer.lagObservableList(serialiserPer.lesArrayFraFil()));
            tabellBilletter.setItems(håndteringBill.lagObservableList(serialiserBill.lesArrayFraFil()));
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
