package org.openjfx.logic.Arrangement;

import javafx.event.Event;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class alertbox {

    public static void display (String title,String message) {
        Stage window = new Stage();

        // Krever at brukeren lukker alert boksen
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(200);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("lukk");
        closeButton.setOnAction(e-> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }

}
