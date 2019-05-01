package org.openjfx.logic.Billett;

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
