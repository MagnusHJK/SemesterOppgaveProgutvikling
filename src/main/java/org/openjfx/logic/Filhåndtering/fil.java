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
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj", "*.gz"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        String path = selectedFile.getPath();

        StringBuffer strb = new StringBuffer();
        try(RandomAccessFile reader = new RandomAccessFile(path, "r")) {
            for(int i = 0; i < 50; i++) {
                strb.append(reader.readLine());
                strb.append("\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not find the specified file");
        }   catch (IOException e) {
            System.err.println("Could not read the specified file. Cause: " + e.getCause());
        }

        System.out.println(strb);

    }

    public static void test() {


    }
}


