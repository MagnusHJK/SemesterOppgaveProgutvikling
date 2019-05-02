package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ControllerAdmin {


    //Hoved pane og Tabs
    @FXML
    private AnchorPane paneAdmin;

    @FXML
    private TabPane tabpaneAdmin;

    @FXML
    private Tab tabOversikt;

    @FXML
    private ControllerAdminOversikt controllerAdminOversikt;

    @FXML
    private AnchorPane paneAdminOversikt;

    @FXML
    private Tab tabLeggTil;

    @FXML
    private ControllerAdminLeggTil controllerAdminLeggTil;

    @FXML
    private AnchorPane paneAdminLeggTil;

    @FXML
    private Tab tabEndre;

    @FXML
    private ControllerAdminEndre controllerAdminEndre;

    @FXML
    private AnchorPane paneAdminEndre;

    @FXML
    private Tab tabSlett;

    @FXML
    private AnchorPane paneAdminSlett;

    @FXML
    private ControllerAdminSlett controllerAdminSlett;

    @FXML
    private Tab tabReset;

    @FXML
    private AnchorPane paneAdminReset;

    @FXML
    private ControllerAdminReset controllerAdminReset;

    @FXML
    private Tab tabFilbehandling;

    @FXML
    private AnchorPane paneAdminFilbehandling;

    @FXML
    private ControllerAdminFilbehandling controllerAdminFilbehandling;

    @FXML
    private Button btnHjemSide;



    @FXML
    private void actionHjemSide(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/sceneMain.fxml"));
        paneAdmin.getChildren().setAll(pane);
        System.out.println("Tar deg til Hjem siden.");
    }

}
