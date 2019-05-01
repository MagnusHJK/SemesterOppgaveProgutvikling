package org.openjfx.logic.Arrangement;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleSerialiser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//Klasse for håndtering av Arrangement fra GUI, lages, endres eller slettes
public class ArrangementHåndtering {


    //Endrer et spesifikt arrangement
    /*public boolean endreArrangement(Arrangement arrangement){
        return true;
    }*/





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

    //Finner all info om det arrangementet du trykker på
    public String filtrerArrangementDetaljer(ArrayList<Arrangement> liste, Arrangement arrangement){
        for(Arrangement index : liste){
            if(index.getArrangementID().equals(arrangement.getArrangementID())){
                return "Tittel: " + arrangement.getNavn() + "\n" +
                       "Artist: " + arrangement.getArtist() + "\n" +
                       "Sted: " + arrangement.getSted() + " " + arrangement.getType() +"\n" +
                       "Dato/Tid: " + arrangement.getDato() + " - " + arrangement.getTidspunkt() + "\n" +
                       "Pris: " + arrangement.getBillettPris() + "\n" +
                       "Maks Billetter: " + arrangement.getBillettMaks() + "\n" +
                       "Beskrivelse: " + arrangement.getBeskrivelse() + "\n";
            }
        }
        return "";
    }

    public void oppdaterArrangementSalg(Arrangement arrangement){
        ArrangementSerialiser serialiser = new ArrangementSerialiser();

        try{
            ArrayList<Arrangement> liste = serialiser.lesArrayFraFil();

            //Fjerner det gamle arrangementet og legger til det nye, med riktige plasser
            liste.removeIf(Arrangement -> Arrangement.getArrangementID().equals(arrangement.getArrangementID()));
            liste.add(arrangement);

            serialiser.skrivArrayTilFil(liste);

        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void slettArrangement(Arrangement arrangement){
        ArrangementSerialiser serialiser = new ArrangementSerialiser();

        try{
            ArrayList<Arrangement> liste = serialiser.lesArrayFraFil();

            liste.removeIf(Arrangement -> Arrangement.getArrangementID().equals(arrangement.getArrangementID()));

            serialiser.skrivArrayTilFil(liste);
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public void endreArrangement(Arrangement arrangement) {
        ArrangementSerialiser serialiser = new ArrangementSerialiser();

        try {
            ArrayList<Arrangement> liste = serialiser.lesArrayFraFil();

            liste.removeIf(Arrangement -> Arrangement.getArrangementID().equals(arrangement.getArrangementID()));
            liste.add(arrangement);

            serialiser.skrivArrayTilFil(liste);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
