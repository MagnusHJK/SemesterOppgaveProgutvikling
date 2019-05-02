package org.openjfx.logic.Filhåndtering;

import org.openjfx.logic.Person.PersonSerialiser;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.filException;
import org.openjfx.logic.exceptions.inputException;
import org.openjfx.logic.exceptions.klasseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class velgFilSkriv {
    public static void velgFilSkriv(String navn, String path, ArrayList<String> data,String txt) {

        String subString = navn.substring(navn.lastIndexOf("."), navn.length());
        if (subString.equals(".csv")) {
            try {
                skrivTilFil skrivTilCsv = new skrivTilCsv();
                Serialisering lesFraFil = new Serialisering();

                skrivTilCsv.skrivTilCsv(lesFraFil.lesFraFil(txt), path);
            } catch(FileNotFoundException fnf) {
                alertbox.feil(filException.filException());
            } catch(ClassNotFoundException cnf) {
                alertbox.feil(klasseException.klasseException());
            } catch (IOException io) {
                alertbox.feil(inputException.ioException());
            }
        } else {
            skrivTilFil skrivTilJobj = new skriTilJobj();
            skrivTilJobj.skrivTilJobj(data,path);
        }
    }
}
