package org.openjfx.logic.test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementHåndtering;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;

import java.util.ArrayList;



public class test {

    public ObservableList<Arrangement> lagObservableList(ArrayList<Arrangement> ArrayListe){

        ObservableList<Arrangement> observListe = FXCollections.observableArrayList();
        observListe.addAll(ArrayListe);

        return observListe;
    }


    public static void main(String[] args) throws Exception{
        ArrangementSerialiser test = new ArrangementSerialiser();


        ArrayList<Arrangement> liste = new ArrayList<>();


        liste.add(new Arrangement(Kontaktperson.lagKontaktpersonListe().get(0), Lokale.lagLokaleList().get(0),
                "La La Land", "Emma Stone", "Ottestad", "Sykt bra film.", 100, 69));


        liste.add(new Arrangement(Kontaktperson.lagKontaktpersonListe().get(1), Lokale.lagLokaleList().get(1),
                "Cats", "Gunnar", "Ottestad", "Sykt kule katter", 250, 100));


        ArrangementHåndtering ob = new ArrangementHåndtering();
        System.out.println(ob.lagObservableList(Arrangement.lagArrangementListe()));
        System.out.println(Arrangement.lagArrangementListe());



    }
}
