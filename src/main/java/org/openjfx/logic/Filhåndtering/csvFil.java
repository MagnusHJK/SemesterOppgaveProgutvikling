package org.openjfx.logic.Filhåndtering;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.logic.exceptions.alertbox;

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
            fnf.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }

        return data;
    }

    @Override
    public String lesJobjFil(String path, ArrayList<String> data) {
        return "hei";
    }

    @Override
    public void lesObjFil() {
        
    }


}
