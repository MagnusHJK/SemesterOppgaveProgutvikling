package org.openjfx.logic.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.inputException;
import org.openjfx.logic.exceptions.klasseException;

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
        }catch(IOException e){
            alertbox.feil(inputException.ioException());
        } catch(ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }

    }
}
