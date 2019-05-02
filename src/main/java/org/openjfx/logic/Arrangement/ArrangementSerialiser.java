package org.openjfx.logic.Arrangement;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.filException;
import org.openjfx.logic.exceptions.inputException;
import org.openjfx.logic.exceptions.klasseException;

import java.io.*;
import java.util.ArrayList;


//Klasse som håndterer alt av serialisering av Arrangementer
public class ArrangementSerialiser implements Serializable {


    //Leser Arrangement array fra databasefilen TODO legg til trådprogrammering
    public ArrayList<Arrangement> lesArrayFraFil() throws IOException, ClassNotFoundException, FileNotFoundException {
        ArrayList<Arrangement> arrangementListe = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("databases/arrangement.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            arrangementListe = (ArrayList<Arrangement>)ois.readObject();

            ois.close();
            fis.close();
        }catch(FileNotFoundException e){
            alertbox.feil(filException.filException());
        }
        catch(IOException ois){
            System.err.println("Feil i I/O");
            alertbox.feil(inputException.ioException());

        }catch(ClassNotFoundException c){
            alertbox.feil(klasseException.klasseException());

        }

        return arrangementListe;
    }


    //TODO: trådprogrammering
    public void skrivArrayTilFil(ArrayList<Arrangement> arrangementList) throws IOException, ClassNotFoundException, FileNotFoundException{
        try{
            FileOutputStream fos = new FileOutputStream("databases/arrangement.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arrangementList);
            oos.close();
            fos.close();
        }catch(IOException ioe){
           alertbox.feil("dd");
        }
    }
}
