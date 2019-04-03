package org.openjfx.logic.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Element {

    //Liste over forskjellige elementer som kan lages/endre/etc...
    public static ObservableList<String> lagElementListe() {
        ObservableList<String> ElementList = FXCollections.observableArrayList();

        ElementList.addAll("Lokale","Kontaktperson","Arrangement");

        return ElementList;
    }
}
