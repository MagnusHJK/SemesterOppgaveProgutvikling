package org.openjfx.logic.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleSerialiser;
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

    public void endrePerson(Kontaktperson kontaktperson) {
        PersonSerialiser serialiser = new PersonSerialiser();

        try {
            ArrayList<Kontaktperson> liste = serialiser.lesArrayFraFil();

            liste.removeIf(Kontaktperson -> Kontaktperson.getPersonID().equals(kontaktperson.getPersonID()));
            liste.add(kontaktperson);

            serialiser.skrivArrayTilFil(liste);

        } catch (IOException io) {
            alertbox.feil(inputException.ioException());
        } catch(ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }
    }

    //Finner all info om det arrangementet du trykker på
    public String filtrerKontaktpersonDetaljer(ArrayList<Kontaktperson> liste, Kontaktperson kontaktperson){
        for(Kontaktperson index : liste){
            if(index.getPersonID().equals(kontaktperson.getPersonID())){
                return "Fornavn: " + kontaktperson.getFornavn() + "\n" +
                        "Etternavn: " + kontaktperson.getEtternavn() + "\n" +
                        "Telefon: " + kontaktperson.getTelefon() + "\n" +
                        "Epost: " + kontaktperson.getEpost() + "\n" +
                        "Nettside: " + kontaktperson.getNettside() + "\n" +
                        "Virksomhet: " + kontaktperson.getVirksomhet() + "\n" +
                        "Opplysninger: " + kontaktperson.getOpplysninger() + "\n";
            }
        }
        return "";
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
