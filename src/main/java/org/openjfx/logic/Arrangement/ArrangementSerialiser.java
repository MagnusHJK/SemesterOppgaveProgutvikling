package org.openjfx.logic.Arrangement;

import org.openjfx.logic.Person.Kontaktperson;

import java.io.*;
import java.util.ArrayList;


//Klasse som håndterer alt av serialisering av Arrangementer
public class ArrangementSerialiser implements Serializable {

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


    public void skrivArrayTilFil(ArrayList<Arrangement> arrangementList) throws IOException, ClassNotFoundException, FileNotFoundException{
        //TODO: Skriv metode for å serialisere array
    }
}
