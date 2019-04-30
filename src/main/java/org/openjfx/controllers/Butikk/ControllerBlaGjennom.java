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
import org.openjfx.logic.exceptions.nullException;
import org.openjfx.logic.exceptions.arrangementException;


import java.io.FileNotFoundException;
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
        kolonneArrangementBillettMaks.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("billettMaks"));
        kolonneArrangementPris.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("billettPris"));
        kolonneArrangementDato.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("dato"));
        kolonneArrangementTidspunkt.setCellValueFactory(new PropertyValueFactory<Arrangement, String>("tidspunkt"));


    }

    @FXML
    private ListView<Lokale> listLokale;

    @FXML
    private TableView<Arrangement> tabellArrangement;

    @FXML
    private TableColumn<Arrangement, String> kolonneArrangementNavn;

    @FXML
    private TableColumn<Arrangement, String> kolonneArrangementBillettMaks;

    @FXML
    private TableColumn<Arrangement, String> kolonneArrangementPris;

    @FXML
    private TableColumn<Arrangement, String> kolonneArrangementDato;

    @FXML
    private TableColumn<Arrangement, String> kolonneArrangementTidspunkt;

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
    private void actionLokaleTrykk(MouseEvent event) throws nullException{

        //Finner hvilket lokale man trykker på
        Lokale lokale = listLokale.getSelectionModel().getSelectedItem();


        ArrangementHåndtering filterArr = new ArrangementHåndtering();
        ArrangementSerialiser serialiserArr = new ArrangementSerialiser();

        //TODO fikse exceptions etter serialiserings id-ene er fikset

        //Sjekker om det valgte lokalet har noen arrangementer som bruker dette lokalet.
        try {
            tabellArrangement.setItems(filterArr.filtrerArrangementer(serialiserArr.lesArrayFraFil(), lokale));
        } catch (NullPointerException npe) {
            //alertbox.display(nullException.nullException());
        } catch (IOException  | ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }

    }


    @FXML
    private void actionArrangementTrykk(MouseEvent event) throws arrangementException{
        Arrangement arrangement = tabellArrangement.getSelectionModel().getSelectedItem();
        ArrangementHåndtering filterArr = new ArrangementHåndtering();
        ArrangementSerialiser serialiserArr = new ArrangementSerialiser();

        btnKjopSide.setDisable(false);



        //Filtrerer riktig arrangement og setter teksten på labelen til å være informasjon om arrangementet
        //Velger kontaktperson fra samme arrangement og setter labelen til informasjon om han/henne
        try{
            //lblArrangementDetaljer.setText(arrangement.getBeskrivelse().toString());
            lblArrangementDetaljer.setText(filterArr.filtrerArrangementDetaljer(serialiserArr.lesArrayFraFil(), arrangement));
            lblKontaktpersonDetaljer.setText(arrangement.getKontaktperson().toString());

        }catch(ClassNotFoundException | IOException io){
            alertbox.feil(arrangementException.arrangementException());
        }
    }



    @FXML
    private void actionHjemSide(ActionEvent event) throws IOException {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/sceneMain.fxml"));
            paneBlaGjennom.getChildren().setAll(pane);
            System.out.println("Tar deg til Hjem siden.");
        } catch (IOException e) {
            alertbox.feil("En feil oppstod");
        }
    }


    //Sjekker om et Arrangement er valgt, så henter den Controller fra neste side og kjører metode for å overføre-
    //Arrangement objekt til neste Scene
    @FXML
    private void actionKjøpSide(ActionEvent event) throws IOException {
        if(tabellArrangement.getSelectionModel().getSelectedItem() != null){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/org/openjfx/sceneKjøp.fxml"));
                AnchorPane pane = loader.load();

                Arrangement arrangement = tabellArrangement.getSelectionModel().getSelectedItem();
                ControllerKjøp controllerKjøp = loader.getController();
                controllerKjøp.arrangementHenter(arrangement);

                paneBlaGjennom.getChildren().setAll(pane);
            } catch (RuntimeException e) {
                alertbox.feil(valgException.valgException());
            }
        }
    }
}
