package org.openjfx.logic.Arrangement;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;

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
            e.printStackTrace();
            //alertbox.display("Feil","En feil oppstod");
        }
        catch(IOException ois){
            System.err.println("Feil i I/O");
            ois.printStackTrace();
            //alertbox.display("Feil","En feil oppstod");
        }catch(ClassNotFoundException c){
            System.err.println("Feil klasse");
            //alertbox.display("Feil","En feil oppstod");
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
            //alertbox.display("Feil","En feil oppstod");
        }

    }
}
