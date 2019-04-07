package org.openjfx.logic.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class PersonHåndtering {

    //Lager observable liste som JavaFX kan bruke
    public ObservableList<Kontaktperson> lagObservableList(ArrayList<Kontaktperson> ArrayListe){

        ObservableList<Kontaktperson> observListe = FXCollections.observableArrayList();
        observListe.addAll(ArrayListe);

        return observListe;
    }
}
