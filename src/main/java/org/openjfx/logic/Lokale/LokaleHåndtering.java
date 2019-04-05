package org.openjfx.logic.Lokale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class LokaleHåndtering {

    //Lager en ObservableList som JavaFX kan bruke i sine komponenter
    public ObservableList<Lokale> lagObservableList(ArrayList<Lokale> ArrayListe) throws Exception{

        ObservableList<Lokale> observListe = FXCollections.observableArrayList();
        observListe.addAll(ArrayListe);

        return observListe;
    }
}
