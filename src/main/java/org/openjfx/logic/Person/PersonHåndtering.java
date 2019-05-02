package org.openjfx.logic.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PersonHåndtering {

    //Lager observable liste som JavaFX kan bruke
    public ObservableList<Kontaktperson> lagObservableList(ArrayList<Kontaktperson> ArrayListe){

        ObservableList<Kontaktperson> observListe = FXCollections.observableArrayList();
        observListe.addAll(ArrayListe);

        return observListe;
    }

    //TODO Exceptions
    public void slettPerson(Kontaktperson person){
        PersonSerialiser serialiser = new PersonSerialiser();

        try{
            ArrayList<Kontaktperson> liste = serialiser.lesArrayFraFil();

            liste.removeIf(Kontaktperson -> Kontaktperson.getPersonID().equals(person.getPersonID()));

            serialiser.skrivArrayTilFil(liste);
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Kontaktperson> lagKontaktpersonListe(){
        ArrayList<Kontaktperson>kontaktpersonListe = new ArrayList<>();

        kontaktpersonListe.add(new Kontaktperson("Dest23","Magnus", "Hjelmen", "91994468",
                "Magnus@email.com", "example.com", "Google", "I am very cool"));

        kontaktpersonListe.add(new Kontaktperson("LDKFG445","Tonje", "Pettersen", "12345678",
                "Tonje@email.com", "example.com", "Microsoft", "Jag är från sverige"));


        return kontaktpersonListe;
    }
}
