package org.openjfx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class ControllerMain {


    public void initialize() throws Exception{

    }

    @FXML
    private AnchorPane paneHjem;


    @FXML
    private Label label;

    @FXML
    private Button btnAdminSide;


    @FXML
    private void actionAdminSide(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/sceneAdmin.fxml"));
        paneHjem.getChildren().setAll(pane);
        System.out.println("Tar deg til Admin siden.");
    }

}
