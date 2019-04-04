package org.openjfx.logic.Arrangement;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static javafx.scene.input.KeyCode.T;

//Klasse for håndtering av Arrangement fra GUI, lages, endres eller slettes
public class ArrangementHåndtering {


    //Endrer et spesifikt arrangement
    public boolean endreArrangement(Arrangement arrangement){
        return true;
    }



    //Lager en ObservableList som JavaFX kan bruke i sine komponenter
    public ObservableList<Arrangement> lagObservableList(ArrayList<Arrangement> arrangementListe) throws Exception{

        ObservableList<Arrangement> arrangementObservableListe = FXCollections.observableArrayList();
        arrangementObservableListe.addAll(arrangementListe);

        return arrangementObservableListe;
    }


    //Lager ArrayList
    public List<Arrangement> lagArrayList(ObservableList<Arrangement> arrangementObservableList){
        List<Arrangement> ArrangementList = arrangementObservableList.stream().collect(Collectors.toList());

        return ArrangementList;
    }
}
