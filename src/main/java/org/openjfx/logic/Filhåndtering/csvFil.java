package org.openjfx.logic.Filhåndtering;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class csvFil extends fil {

    @Override
    public void lesCsvFil() {

        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        String path = selectedFile.getPath();

        String rad;
        List<String> data = new ArrayList<>();
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(path));
            while ((rad = buffer.readLine()) != null) {
                data.add(rad);
            }
            buffer.close();

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
        System.out.println(data);
    }
}
