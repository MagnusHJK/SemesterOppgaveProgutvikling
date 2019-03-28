package org.openjfx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.openjfx.logic.AppInfo.AppInfo;


public class ControllerAppInfo {
    AppInfo info = new AppInfo();


    public void initialize(){
        lblAppInfo.setText(info.toString());
    }


    @FXML
    private Label lblAppInfo;

    @FXML
    private Button btnLukk;


    @FXML
    private void actionLukk(ActionEvent event){
        Stage scene = (Stage) btnLukk.getScene().getWindow();
        scene.close();
    }
}
