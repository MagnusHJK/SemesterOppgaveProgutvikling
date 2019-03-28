package org.openjfx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ControllerBlaGjennom {

    public void initialize() throws Exception{

    }

    @FXML
    private AnchorPane paneBlaGjennom;

    @FXML
    private Button btnKjopSide;


    @FXML
    private void actionHjemSide(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/sceneMain.fxml"));
        paneBlaGjennom.getChildren().setAll(pane);
        System.out.println("Tar deg til Hjem siden.");
    }


    @FXML
    private void actionKjopSide(ActionEvent event) throws IOException {
        System.out.println("Du trykket på kjøp knappen");
    }

}
