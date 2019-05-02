package org.openjfx.logic.Filhåndtering;

import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.filException;
import org.openjfx.logic.exceptions.inputException;
import org.openjfx.logic.exceptions.klasseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class jobjFil extends fil{
    @Override
    public ArrayList<String>  lesJobjFil(String path, ArrayList<String> data)  {
        try {
            FileInputStream filInput = new FileInputStream(path);
            ObjectInputStream objectInput = new ObjectInputStream(filInput);

            data = (ArrayList)objectInput.readObject();

            filInput.close();
            objectInput.close();
        } catch(FileNotFoundException fnf) {
            alertbox.feil(filException.filException());
        } catch(IOException io) {
            alertbox.feil(inputException.ioException());
        } catch(ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }

        return data;
    }

    @Override
    public ArrayList<String> lesCsvFil(String path, ArrayList<String> data) {
        return data;
    }
}
