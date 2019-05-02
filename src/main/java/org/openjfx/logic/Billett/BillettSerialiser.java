package org.openjfx.logic.Billett;

import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.filException;
import org.openjfx.logic.exceptions.inputException;
import org.openjfx.logic.exceptions.klasseException;

import java.io.*;
import java.util.ArrayList;

public class BillettSerialiser {
    //Leser Arrangement array fra databasefilen TODO legg til trådprogrammering
    public ArrayList<Billett> lesArrayFraFil() throws IOException, ClassNotFoundException, FileNotFoundException {
        ArrayList<Billett> billettListe = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("databases/billetter.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            billettListe = (ArrayList<Billett>)ois.readObject();

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

        return billettListe;
    }


    //TODO: trådprogrammering
    public void skrivArrayTilFil(ArrayList<Billett> billettListe) throws IOException, ClassNotFoundException, FileNotFoundException{
        try{
            FileOutputStream fos = new FileOutputStream("databases/billetter.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(billettListe);
            oos.close();
            fos.close();
        }catch(IOException ioe){
            //alertbox.display("Feil","En feil oppstod");
        }
    }
}
