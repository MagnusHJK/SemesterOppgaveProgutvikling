package org.openjfx.controllers.Butikk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Billett.Billett;
import org.openjfx.logic.Billett.BillettHåndtering;
import org.openjfx.logic.Billett.BillettNummerTextField;
import org.openjfx.logic.exceptions.alertbox;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ControllerKjøp {

    private Arrangement valgtArrangement;
    private int antallBilletter;


    @FXML
    private AnchorPane paneKjøp;

    @FXML
    private BillettNummerTextField textfieldAntallBilletter;

    @FXML
    private TextField textfieldTelefon;

    @FXML
    private Label lblPris;

    @FXML
    private Label lblArrangement;

    @FXML
    private Label lblBillettInfo;


    //Metode for å hente objekt fra forrige scene
    public void arrangementHenter(Arrangement arrangement){
        valgtArrangement = arrangement;
        lblArrangement.setText(valgtArrangement.getNavn() + " [" + valgtArrangement.getDato() + " - " + valgtArrangement.getTidspunkt() + "]");
    }




    //TODO Legg til så 1 er minimum
    @FXML
    private void actionAntallBilletter(KeyEvent event){
        int pris = 0;

        try{
            antallBilletter = Integer.parseInt(textfieldAntallBilletter.getText());
            pris = antallBilletter * valgtArrangement.getBillettPris();
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        lblPris.setText(Integer.toString(pris));
    }


    //TODO Skriv metode for plassnummer,
    @FXML
    private void actionBekreftBillett(ActionEvent event){
        BillettHåndtering håndtering = new BillettHåndtering();

        int plassnummer = 0;
        String telefonnummer = textfieldTelefon.getText();

        for(int i = 0; i < antallBilletter; i++){
            plassnummer = håndtering.finnPlassnummer(valgtArrangement);

            Billett billett = new Billett(valgtArrangement, plassnummer, valgtArrangement.getSted(),
                                          valgtArrangement.getDato(), valgtArrangement.getTidspunkt(), telefonnummer);

            valgtArrangement.getSalg()[plassnummer] = billett;
        }

        lblBillettInfo.setText(valgtArrangement.getSalg()[plassnummer].toString());

        //TODO Gjør om til at det legges inn i Billett Array!!
        try{
            ArrangementSerialiser serialiser = new ArrangementSerialiser();
            ArrayList<Arrangement> liste = serialiser.lesArrayFraFil();

            liste.add(valgtArrangement);
            System.out.println(liste);

            serialiser.skrivArrayTilFil(liste);
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }



    @FXML
    private void actionBlaGjennomSide(ActionEvent event) throws IOException {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/sceneBlaGjennom.fxml"));
            paneKjøp.getChildren().setAll(pane);
            System.out.println("Tar det til Bla Gjennom siden.");
        } catch (IOException e) {
            alertbox.feil("En feil oppstod");
            e.printStackTrace();
        }
    }
}
