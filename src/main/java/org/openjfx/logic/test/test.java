package org.openjfx.logic.test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementHåndtering;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static javafx.scene.input.KeyCode.T;

public class test {
    public static void main(String[] args) throws Exception{
        ArrangementSerialiser test = new ArrangementSerialiser();


        ArrayList<Arrangement> liste = new ArrayList<>();


        liste.add(new Arrangement(Kontaktperson.lagKontaktpersonListe().get(0), Lokale.lagLokaleList().get(0),
                "La La Land", "Emma Stone", "Ottestad", "Sykt bra film.", 100, 69));


        liste.add(new Arrangement(Kontaktperson.lagKontaktpersonListe().get(1), Lokale.lagLokaleList().get(1),
                "Cats", "Gunnar", "Ottestad", "Sykt kule katter", 250, 100));


        test.skrivArrayTilFil(liste);

    }
}
