package org.openjfx.logic.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Person.Kontaktperson;

public class Element {


    //Liste over forskjellige elementer som kan lages/endre/etc...
    public ObservableList<String> lagElementListe() {
        ObservableList<String> ElementList = FXCollections.observableArrayList();

        ElementList.addAll("Lokale","Kontaktperson","Arrangement");

        return ElementList;
    }


    //Liste over forskjellige elemener som kan spesifikt SLETTES
    public ObservableList<String> lagElementListeSlett(){
        ObservableList<String> ElementList = FXCollections.observableArrayList();

        ElementList.addAll("Lokale", "Kontaktperson", "Arrangement", "Billett");

        return ElementList;
    }


    //Sjekker hvilket element brukeren velger og viser dermet riktige inputfelter
    public void elementValg(String valg){

    }
}
