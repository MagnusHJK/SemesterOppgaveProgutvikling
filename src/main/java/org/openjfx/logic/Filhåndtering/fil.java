package org.openjfx.logic.Filhåndtering;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.openjfx.controllers.ControllerMain;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Person;
import org.openjfx.logic.exceptions.alertbox;

public abstract class fil {

    public static void start() throws IOException {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        String path = selectedFile.getPath();

        String rad;
        List<String> data = new ArrayList<>();

        try{
            BufferedReader buffer = new BufferedReader(new FileReader(path));

            while((rad = buffer.readLine()) != null) {
                data.add(rad);
            }
            buffer.close();
        } catch(FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch(IOException io) {
            io.printStackTrace();
        }

        System.out.println(data);


    }

    public static void test() {

    }

}


