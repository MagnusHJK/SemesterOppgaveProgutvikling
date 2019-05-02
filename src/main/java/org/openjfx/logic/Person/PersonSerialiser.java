package org.openjfx.logic.Person;

import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.filException;
import org.openjfx.logic.exceptions.inputException;
import org.openjfx.logic.exceptions.klasseException;

import java.io.*;
import java.util.ArrayList;

public class PersonSerialiser {

    //Leser Lokale array fra databasefilen TODO legg til trådprogrammering, exceptions
    public ArrayList<Kontaktperson> lesArrayFraFil() throws IOException, ClassNotFoundException, FileNotFoundException {
        ArrayList<Kontaktperson> personListe = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("databases/person.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            personListe = (ArrayList<Kontaktperson>)ois.readObject();

            ois.close();
            fis.close();
        }catch(FileNotFoundException e){
            alertbox.feil(filException.filException());
            //alertbox.display("Feil","En feil oppstod");
        }
        catch(IOException ois){
            alertbox.feil(("aa"));
            ois.getCause();
        }catch(ClassNotFoundException c){
            alertbox.feil(klasseException.klasseException());
        }

        return personListe;
    }

    //TODO: trådprogrammering, exceptions
    public void skrivArrayTilFil(ArrayList<Kontaktperson> personList) throws IOException, ClassNotFoundException, FileNotFoundException{
        try{
            FileOutputStream fos = new FileOutputStream("databases/person.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(personList);
            oos.close();
            fos.close();
        }catch(IOException ioe){
            //alertbox.display("Feil","En feil oppstod");
        }

    }


}
