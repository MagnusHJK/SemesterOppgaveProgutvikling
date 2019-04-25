package org.openjfx.logic.test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementHåndtering;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonSerialiser;

import java.util.ArrayList;



public class test {

    public ObservableList<Arrangement> lagObservableList(ArrayList<Arrangement> ArrayListe){

        ObservableList<Arrangement> observListe = FXCollections.observableArrayList();
        observListe.addAll(ArrayListe);

        return observListe;
    }


    public static void main(String[] args) throws Exception{
        //ArrangementSerialiser testArrangement = new ArrangementSerialiser();
        //testArrangement.skrivArrayTilFil(Arrangement.lagArrangementListe());
        //System.out.println(testArrangement.lesArrayFraFil());

        //LokaleSerialiser testLokale = new LokaleSerialiser();
        //testLokale.skrivArrayTilFil(Lokale.lagLokaleList());
        //System.out.println(testLokale.lesArrayFraFil());


        PersonSerialiser testPerson = new PersonSerialiser();
        testPerson.skrivArrayTilFil(Kontaktperson.lagKontaktpersonListe());
        System.out.println(testPerson.lesArrayFraFil());





    }
}
