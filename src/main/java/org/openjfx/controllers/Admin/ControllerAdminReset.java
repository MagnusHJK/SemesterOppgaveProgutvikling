package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

public class ControllerAdminReset {


    @FXML
    private Label lblReset;

    @FXML
    private void actionLokaleReset(ActionEvent event){
        LokaleHåndtering lokaleHåndtering = new LokaleHåndtering();
        LokaleSerialiser lokaleSerialiser = new LokaleSerialiser();

        ArrayList<Lokale> lokaleListe = lokaleHåndtering.lagLokaleListe();
        lblReset.setText("Lokaler er resatt");

        try{
            lokaleSerialiser.skrivArrayTilFil(lokaleListe);
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void actionKontaktpersonReset(ActionEvent event){
        PersonHåndtering personHåndtering = new PersonHåndtering();
        PersonSerialiser personSerialiser = new PersonSerialiser();

        ArrayList<Kontaktperson> personListe = personHåndtering.lagKontaktpersonListe();

        lblReset.setText("Kontaktpersoner er resatt");
        try{
            personSerialiser.skrivArrayTilFil(personListe);
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void actionArrangementReset(ActionEvent event){
        ArrangementHåndtering arrangementHåndtering = new ArrangementHåndtering();
        ArrangementSerialiser arrangementSerialiser = new ArrangementSerialiser();

        ArrayList<Arrangement> arrangementListe = arrangementHåndtering.lagArrangementListe();

        lblReset.setText("Arrangementer er resatt");

        try{
            arrangementSerialiser.skrivArrayTilFil(arrangementListe);
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    @FXML
    private void actionBillettReset(ActionEvent event){
        BillettHåndtering billettHåndtering = new BillettHåndtering();
        BillettSerialiser billettSerialiser = new BillettSerialiser();

        ArrayList<Billett> billettListe = billettHåndtering.lagBillettListe();

        lblReset.setText("Billetter er resatt");
       // ArrayList<Billett> billettListe = billettHåndtering.;

        try{
            billettSerialiser.skrivArrayTilFil(billettListe);
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

}
