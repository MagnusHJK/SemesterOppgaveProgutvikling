package org.openjfx.logic.Filhåndtering;

import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.filException;
import org.openjfx.logic.exceptions.inputException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class skriTilJobj extends skrivTilFil{


    @Override
    public void skrivTilJobj(ArrayList data, String path) {
        try {
            FileOutputStream fileOutput = new FileOutputStream(path);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

            objectOutput.writeObject(data);

            fileOutput.close();
            objectOutput.close();

        } catch(FileNotFoundException fnf) {
            alertbox.feil(filException.filException());
        } catch(IOException io) {
            alertbox.feil(inputException.ioException());
        }
    }

    @Override
    public void skrivTilCsv(ArrayList data, String path) {

    }

}
