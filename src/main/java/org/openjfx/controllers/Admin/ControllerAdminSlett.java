package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.openjfx.logic.Admin.Element;
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
import java.util.ArrayList;

public class ControllerAdminSlett {

    public void initialize() throws Exception{
        Element elementerListe = new Element();

        choiceSlettValg.setItems(elementerListe.lagElementListeSlett());
    }


    @FXML
    private ChoiceBox<String> choiceSlettValg;

    @FXML
    private Button btnSlettValg;

    @FXML
    private ListView<Lokale> listLokale;

    @FXML
    private ListView<Kontaktperson> listKontaktperson;

    @FXML
    private ListView<Arrangement> listArrangement;

    @FXML
    private ListView<Billett> listBillett;

    @FXML
    private Button btnSlettElement;




    //Viser forskjellig listview over elementer utifra hvilken type som velges.
    //Disse må splittes i forskjellige views ettersom ListView ikke takler liste med forskjellige klassetyper
    //TODO Execption
    @FXML
    private void actionSlettValg(ActionEvent event) throws Exception{
        String valg = choiceSlettValg.getSelectionModel().getSelectedItem();

        if(valg.equals("Lokale")){
            listLokale.setVisible(true);
            listKontaktperson.setVisible(false);
            listArrangement.setVisible(false);
            listBillett.setVisible(false);

            try{
                LokaleSerialiser serialiser = new LokaleSerialiser();
                LokaleHåndtering håndtering = new LokaleHåndtering();
                ArrayList<Lokale> liste = serialiser.lesArrayFraFil();

                listLokale.setItems(håndtering.lagObservableList(liste));

            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }


        }else if(valg.equals("Kontaktperson")){
            listLokale.setVisible(false);
            listKontaktperson.setVisible(true);
            listArrangement.setVisible(false);
            listBillett.setVisible(false);

            try{
                PersonSerialiser serialiser = new PersonSerialiser();
                PersonHåndtering håndtering = new PersonHåndtering();
                ArrayList<Kontaktperson> liste = serialiser.lesArrayFraFil();

                listKontaktperson.setItems(håndtering.lagObservableList(liste));
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }

        }else if(valg.equals("Arrangement")){
            listLokale.setVisible(false);
            listKontaktperson.setVisible(false);
            listArrangement.setVisible(true);
            listBillett.setVisible(false);

            try{
                ArrangementSerialiser serialiser = new ArrangementSerialiser();
                ArrangementHåndtering håndtering = new ArrangementHåndtering();
                ArrayList<Arrangement> liste = serialiser.lesArrayFraFil();

                listArrangement.setItems(håndtering.lagObservableList(liste));
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }else if(valg.equals("Billett")){
            listLokale.setVisible(false);
            listKontaktperson.setVisible(false);
            listArrangement.setVisible(false);
            listBillett.setVisible(true);

            try{
                BillettSerialiser serialiser = new BillettSerialiser();
                BillettHåndtering håndtering = new BillettHåndtering();
                ArrayList<Billett> liste = serialiser.lesArrayFraFil();

                listBillett.setItems(håndtering.lagObservableList(liste));
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }


    @FXML
    private void actionLokaleTrykk(MouseEvent event){
        btnSlettElement.setDisable(false);
    }

    @FXML
    private void actionKontaktpersonTrykk(MouseEvent event){
        btnSlettElement.setDisable(false);
    }

    @FXML
    private void actionArrangementTrykk(MouseEvent event){
        btnSlettElement.setDisable(false);
    }

    @FXML
    private void actionBillettTrykk(MouseEvent event){
        btnSlettElement.setDisable(false);
    }





    //Sjekker typen brukeren har valgt, henter ut objektet de har valgt og sletter det spesifikke objektet
    @FXML
    private void actionSlettElement(ActionEvent event){
        String valg = choiceSlettValg.getSelectionModel().getSelectedItem();


        if(valg.equals("Lokale")){
            LokaleHåndtering håndtering = new LokaleHåndtering();

            Lokale lokale = listLokale.getSelectionModel().getSelectedItem();

            håndtering.slettLokale(lokale);

        }else if(valg.equals("Kontaktperson")){
            PersonHåndtering håndtering = new PersonHåndtering();

            Kontaktperson kontaktperson = listKontaktperson.getSelectionModel().getSelectedItem();

            håndtering.slettPerson(kontaktperson);

        }else if(valg.equals("Arrangement")){
            ArrangementHåndtering håndtering = new ArrangementHåndtering();

            Arrangement arrangement = listArrangement.getSelectionModel().getSelectedItem();

            håndtering.slettArrangement(arrangement);
        }
        else if(valg.equals("Billett")){
            BillettHåndtering håndteringBill = new BillettHåndtering();
            ArrangementHåndtering håndteringArr = new ArrangementHåndtering();

            Billett billett = listBillett.getSelectionModel().getSelectedItem();

            håndteringBill.slettBillett(billett);
            håndteringArr.oppdaterArrangementSalg(billett.getArrangement());

        }


    }
}
