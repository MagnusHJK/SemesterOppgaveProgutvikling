package org.openjfx.logic.Person;

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
