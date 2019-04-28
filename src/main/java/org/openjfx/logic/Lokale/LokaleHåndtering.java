package org.openjfx.logic.Lokale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class LokaleHåndtering {

    //Lager en ObservableList som JavaFX kan bruke i sine komponenter
    public ObservableList<Lokale> lagObservableList(ArrayList<Lokale> ArrayListe) throws Exception{

        ObservableList<Lokale> observListe = FXCollections.observableArrayList();
        observListe.addAll(ArrayListe);

        return observListe;
    }

    //Sletter det inngitte lokalet fra programmet og databasen
    //Leser array, finner lokalet som matcher og sletter, skriver endring til serialisering
    //TODO Exceptions
    public void slettLokale(Lokale lokale){
        LokaleSerialiser serialiser = new LokaleSerialiser();

        try{
            ArrayList<Lokale> liste = serialiser.lesArrayFraFil();

            liste.removeIf(Lokale -> Lokale.getLokaleID().equals(lokale.getLokaleID()));

            serialiser.skrivArrayTilFil(liste);

        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
