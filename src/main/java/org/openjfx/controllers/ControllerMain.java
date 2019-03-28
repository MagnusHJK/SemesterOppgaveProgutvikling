package org.openjfx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerMain {


    public void initialize(){

    }

    @FXML
    private AnchorPane paneHjem;

    @FXML
    private Button btnAdminSide;

    @FXML
    private Button btnBlaGjennomSide;

    @FXML
    private MenuItem menuitemAppInfo;

    @FXML
    private void actionAppInfo(ActionEvent event) throws IOException{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/org/openjfx/sceneAppInfo.fxml"));
        Stage scene = new Stage();
        scene.setTitle("Applikasjons Informasjon");
        scene.setScene(new Scene(root, 400, 400));
        scene.show();
    }


    @FXML
    private void actionAdminSide(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/sceneAdmin.fxml"));
        paneHjem.getChildren().setAll(pane);
        System.out.println("Tar deg til Admin siden.");
    }


    @FXML
    private void actionBlaGjennomSide(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/sceneBlaGjennom.fxml"));
        paneHjem.getChildren().setAll(pane);
        System.out.println("Tar det til Bla Gjennom siden.");
    }

}
