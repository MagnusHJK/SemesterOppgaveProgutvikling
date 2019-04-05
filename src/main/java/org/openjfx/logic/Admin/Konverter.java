package org.openjfx.logic.Admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.util.ArrayList;


public class Konverter {


    //Lager en ObservableList som JavaFX kan bruke i sine komponenter
    public ObservableList lagObservableList(ArrayList ArrayListe){

        ObservableList observListe = FXCollections.observableArrayList();
        observListe.addAll(ArrayListe);


        return observListe;
    }
}
