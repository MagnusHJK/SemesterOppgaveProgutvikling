package org.openjfx.logic.exceptions;

import javafx.event.Event;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class alertbox {



    public static void feil (String message) {
        Stage window = new Stage();
        final int bredde = 500;
        final int hoyde = 350;

        // APPLICATION_MODAL gjør slik at man ikke kan sende input fra andre felter videre før vinduet er lukket.
        window.initModality(Modality.APPLICATION_MODAL);
        String tittel = "Feilmelding";
        window.setTitle(tittel);
        window.setWidth(bredde);
        window.setHeight(hoyde);
        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("lukk");
        closeButton.setAlignment(Pos.BOTTOM_CENTER);
        closeButton.setOnAction(e-> window.close());

        // Vboks objektet legger alle sine 'barn' vertikalt ovenfor hverandre
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        // Oppretter en ny scene med layoutet til vboksen.
        // Legger også til funksjonen 'showAndWait' som betyr at du er nødt til å
        // lukke vinduet for å kunne gå tilbake til hovedvinduet.
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void godkjent (String message) {
        Stage window = new Stage();
        final int bredde = 800;
        final int hoyde = 350;

        // APPLICATION_MODAL gjør slik at man ikke kan sende input fra andre felter videre før vinduet er lukket.
        window.initModality(Modality.APPLICATION_MODAL);
        String tittel = "Godkjent";
        window.setTitle(tittel);
        window.setWidth(bredde);
        window.setHeight(hoyde);
        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("lukk");
        closeButton.setAlignment(Pos.BOTTOM_CENTER);
        closeButton.setOnAction(e-> window.close());

        // Vboks objektet legger alle sine 'barn' vertikalt ovenfor hverandre
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        // Oppretter en ny scene med layoutet til vboksen. Legger også til funksjonen 'showAndWait' som betyr at du er nødt til å
        // lukke vinduet for å kunne gå tilbake til hovedvinduet.
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }



}
