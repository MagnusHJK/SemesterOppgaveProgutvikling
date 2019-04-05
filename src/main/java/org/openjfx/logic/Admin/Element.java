package org.openjfx.logic.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Element {


    //Liste over forskjellige elementer som kan lages/endre/etc...
    public ObservableList<String> lagElementListe() {
        ObservableList<String> ElementList = FXCollections.observableArrayList();

        ElementList.addAll("Lokale","Kontaktperson","Arrangement");

        return ElementList;
    }


    //Sjekker hvilket element brukeren velger og viser dermet riktige inputfelter
    public void elementValg(String valg){

    }
}
