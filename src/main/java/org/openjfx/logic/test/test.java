package org.openjfx.logic.test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementHåndtering;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleHåndtering;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonHåndtering;
import org.openjfx.logic.Person.PersonSerialiser;

import java.util.ArrayList;



public class test {

    public ObservableList<Arrangement> lagObservableList(ArrayList<Arrangement> ArrayListe){

        ObservableList<Arrangement> observListe = FXCollections.observableArrayList();
        observListe.addAll(ArrayListe);

        return observListe;
    }


    public static void main(String[] args) throws Exception{


        ArrangementSerialiser testArrangement = new ArrangementSerialiser();
        ArrangementHåndtering testArrangementHåndtering = new ArrangementHåndtering();
        ArrayList<Arrangement> arrangementListe = new ArrayList<>();
        arrangementListe = testArrangementHåndtering.lagArrangementListe();
        testArrangement.skrivArrayTilFil(arrangementListe);
        System.out.println(testArrangement.lesArrayFraFil());

        LokaleSerialiser testLokale = new LokaleSerialiser();
        LokaleHåndtering testLokaleHåndtering = new LokaleHåndtering();
        ArrayList<Lokale> lokaleListe = new ArrayList<>();
        testLokale.skrivArrayTilFil(lokaleListe);
        System.out.println(testLokale.lesArrayFraFil());


       PersonSerialiser testPerson = new PersonSerialiser();
       PersonHåndtering testPersonHåndtering = new PersonHåndtering();
       ArrayList<Kontaktperson> personListe = new ArrayList<>();
       testPerson.skrivArrayTilFil(personListe);
       System.out.println(testPerson.lesArrayFraFil());

    }
}
