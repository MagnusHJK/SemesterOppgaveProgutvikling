package org.openjfx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ControllerAdmin {


    @FXML
    private AnchorPane paneAdmin;

    @FXML
    private Label lblAdminSide;

    @FXML
    private Button btnHjemSide;

    @FXML
    private Button btnTest;





    @FXML
    private void actionHjemSide(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/sceneMain.fxml"));
        paneAdmin.getChildren().setAll(pane);
        System.out.println("Tar deg til Hjem siden.");
    }

    public void initialize() {
        // TODO
    }
}
