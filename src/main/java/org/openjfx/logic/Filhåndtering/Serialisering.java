package org.openjfx.logic.Filhåndtering;

import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.filException;
import org.openjfx.logic.exceptions.klasseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Serialisering {
    public ArrayList<String> lesFraFil(String txt) throws IOException, ClassNotFoundException, FileNotFoundException {
        ArrayList<String> liste = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(txt);
            ObjectInputStream ois = new ObjectInputStream(fis);

            liste = (ArrayList<String>)ois.readObject();

            ois.close();
            fis.close();
        }catch(FileNotFoundException e){
            alertbox.feil(filException.filException());
            //alertbox.display("Feil","En feil oppstod");
        }
        catch(IOException ois){
            ois.getCause();
        }catch(ClassNotFoundException c){
            alertbox.feil(klasseException.klasseException());
        }

        return liste;
    }
}
