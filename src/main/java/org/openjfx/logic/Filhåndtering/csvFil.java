package org.openjfx.logic.Filhåndtering;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.filException;
import org.openjfx.logic.exceptions.inputException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class csvFil extends fil {

    @Override
    public ArrayList<String> lesCsvFil(String path,ArrayList data) {
        String rad;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(path));
            while ((rad = buffer.readLine()) != null) {
                data.add(rad);

            }
            buffer.close();
            System.out.println(data);



        } catch (FileNotFoundException fnf) {
           alertbox.feil(filException.filException());
        } catch (IOException io) {
           alertbox.feil(inputException.ioException());
        }

        return data;
    }

    @Override
    public String lesJobjFil(String path, ArrayList<String> data) {
        return "hei";
    }


}
