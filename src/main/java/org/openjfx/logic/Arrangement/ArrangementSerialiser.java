package org.openjfx.logic.Arrangement;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;

import java.io.*;
import java.util.ArrayList;


//Klasse som håndterer alt av serialisering av Arrangementer
public class ArrangementSerialiser implements Serializable {




    //Selv laget serialiser metode
    public void writeObject(ObjectOutputStream s, Arrangement arrangement) throws IOException{
        s.defaultWriteObject();
        s.writeObject(arrangement.getKontaktperson());
        s.writeObject(arrangement.getType());
        s.writeObject(arrangement.getNavn());
        s.writeObject(arrangement.getArtist());
        s.writeObject(arrangement.getSted());
        s.writeObject(arrangement.getBeskrivelse());
        s.writeObject(arrangement.getBillettPris());
        s.writeObject(arrangement.getBillettMaks());
    }


    //Selv laget deserialiser metode TODO FIKS
    public void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException{
        s.defaultReadObject();
        //Arrangement arrangement = new Arrangement(s.readObject(), s.readObject(), s.(), )
    }


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
        }
        catch(IOException ois){
            System.err.println("Feil i I/O");
            ois.printStackTrace();
        }catch(ClassNotFoundException c){
            System.err.println("Feil klasse");
            c.printStackTrace();
        }

        return arrangementListe;
    }


    //TODO: Skriv metode for å serialisere array og trådprogrammering
    public void skrivArrayTilFil(ArrayList<Arrangement> arrangementList) throws IOException, ClassNotFoundException, FileNotFoundException{

        try{
            FileOutputStream fos = new FileOutputStream("databases/arrangement.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arrangementList);
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

    }
}
