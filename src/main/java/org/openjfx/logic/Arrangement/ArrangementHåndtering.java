package org.openjfx.logic.Arrangement;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Lokale.Lokale;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//Klasse for håndtering av Arrangement fra GUI, lages, endres eller slettes
public class ArrangementHåndtering {


    //Endrer et spesifikt arrangement
    public boolean endreArrangement(Arrangement arrangement){
        return true;
    }





    //Lager en ObservableList som JavaFX kan bruke i sine komponenter
    public ObservableList<Arrangement> lagObservableList(ArrayList<Arrangement> ArrayListe) throws Exception{

        ObservableList<Arrangement> observListe = FXCollections.observableArrayList();
        observListe.addAll(ArrayListe);

        return observListe;
    }


    //Lager ArrayList
    public List<Arrangement> lagArrayList(ObservableList<Arrangement> observListe){
        List<Arrangement> ArrangementList = observListe.stream().collect(Collectors.toList());

        return ArrangementList;
    }


    //Ser gjennom Arrangement listen om noen av de hører til Lokalet basert på typen deres
    //returnerer en ObservableList som JavaFX kan bruke
    public ObservableList<Arrangement> filtrerArrangementer(ArrayList<Arrangement> liste, Lokale lokale){
       ObservableList<Arrangement> observListe = FXCollections.observableArrayList();
       observListe.addAll(liste);

        ObservableList<Arrangement> filtrertListe = observListe
                .stream()
                .filter(Arrangement -> Arrangement.getTypeString().equals(lokale.getType()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        return filtrertListe;
    }
}
