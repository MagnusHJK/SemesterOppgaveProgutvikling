package org.openjfx.logic.Lokale;

import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.filException;
import org.openjfx.logic.exceptions.inputException;
import org.openjfx.logic.exceptions.klasseException;

import java.io.*;
import java.util.ArrayList;

public class LokaleSerialiser {


    //Leser Lokale array fra databasefilen TODO legg til trådprogrammering
    public ArrayList<Lokale> lesArrayFraFil() throws IOException, ClassNotFoundException, FileNotFoundException {
        ArrayList<Lokale> lokaleListe = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("databases/lokale.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            lokaleListe = (ArrayList<Lokale>)ois.readObject();

            ois.close();
            fis.close();
        }catch(FileNotFoundException e){
            alertbox.feil(filException.filException());
        }
        catch(IOException ois){
            alertbox.feil(inputException.ioException());
        }catch(ClassNotFoundException c){
           alertbox.feil(klasseException.klasseException());
        }

        return lokaleListe;
    }

    //TODO: trådprogrammering
    public void skrivArrayTilFil(ArrayList<Lokale> lokaleList) throws IOException, ClassNotFoundException, FileNotFoundException{
        try{
            FileOutputStream fos = new FileOutputStream("databases/lokale.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lokaleList);
            oos.close();
            fos.close();
        }catch(IOException ioe){
            //alertbox.display("Feil","En feil oppstod");
        }

    }
}
