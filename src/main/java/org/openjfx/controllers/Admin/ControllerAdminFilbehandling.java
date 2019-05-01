package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Filhåndtering.csvFil;
import org.openjfx.logic.Filhåndtering.jobjFil;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleHåndtering;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonHåndtering;
import org.openjfx.logic.Person.PersonSerialiser;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.Filhåndtering.fil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ControllerAdminFilbehandling {


    @FXML
    private Button lesInnLokaler;
    @FXML
    private Button lesInnAraangement;
    @FXML
    private Button lesInnKontaktperson;

    // TODO finne en måte å legge til fra arrayet

    public void lesFraLokaler(ActionEvent event) throws IOException{

        ArrayList<String> data = new ArrayList<>();

        try {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            String path = selectedFile.getPath();

            String navn = selectedFile.getName();

            String t = navn.substring(navn.lastIndexOf("."), navn.length());

            fil lesCsv = new csvFil();
            lesCsv.lesCsvFil(path,data);
/*
            if (t.equals(".csv")) {
                fil lesCsv = new csvFil();
                lesCsv.lesCsvFil(path,data);
            } else {
                fil lesJobjFil = new jobjFil();
                lesJobjFil.lesJobjFil(path,data);
            }
            */
        } catch (RuntimeException rt) {
            rt.printStackTrace();
        }


        try {
            String ID = data.get(0);
            String navn = data.get(1);
            String type = data.get(2);
            int plasser = Integer.parseInt(data.get(3));

            Lokale lokale = new Lokale(ID,navn,type,plasser);
        } catch(NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    public void lesFraArrangement(ActionEvent event) throws IOException{

        ArrayList<String> data = new ArrayList<>();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            String path = selectedFile.getPath();

            String navn = selectedFile.getName();

            String t = navn.substring(navn.lastIndexOf("."), navn.length());

            fil lesCsv = new csvFil();
            lesCsv.lesCsvFil(path,data);

           /* if (t.equals(".csv")) {
                fil lesCsv = new csvFil();
                lesCsv.lesCsvFil(path,data);
            } else {
                fil lesJobjFil = new jobjFil();
                lesJobjFil.lesJobjFil(path,data);
            }
            */
        } catch(RuntimeException rt) {
            rt.printStackTrace();
        }

        try {

            PersonSerialiser hentArray = new PersonSerialiser();
            PersonHåndtering hånderArray = new PersonHåndtering();

            LokaleSerialiser hentLokale = new LokaleSerialiser();
            LokaleHåndtering hånderLokale = new LokaleHåndtering();



            //alertbox.feil(data.toString());

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            String tittel = "Ekstra informasjon";
            stage.setTitle(tittel);

            ChoiceBox velgPerson = new ChoiceBox();
            velgPerson.setItems(hånderArray.lagObservableList(hentArray.lesArrayFraFil()));
            ChoiceBox Lokale = new ChoiceBox();
            Lokale.setItems(hånderLokale.lagObservableList(hentLokale.lesArrayFraFil()));

            String personFraInput = velgPerson.getSelectionModel().getSelectedItem().toString();
            String lokaleFraInput = Lokale.getSelectionModel().getSelectedItem().toString();

            //TODO Drep meg vær så snill

            String ID = data.get(0);
            String navn= data.get(1);
            String artist = data.get(2);
            String sted = data.get(3);
            String datoTekst = data.get(4);
            LocalDate dato = LocalDate.parse(datoTekst);
            String tidspunkt = data.get(5);
            String beskrivelse = data.get(6);
            int billettPris = Integer.parseInt(data.get(7));
            int billettMaks = Integer.parseInt(data.get(8));
            String tidspunkt = data.get(8);

            Arrangement arrangement = new Arrangement(ID,personFraInput,lokaleFraInput,navn,artist,sted,dato,tidspunkt,beskrivelse,billettPris,billettMaks);

            alertbox.godkjent(arrangement.toString());

            ArrayList <Arrangement> KonverterArrangement = new ArrayList<>();
            KonverterArrangement.add(arrangement);
            ArrangementSerialiser serialiser = new ArrangementSerialiser();
            serialiser.skrivArrayTilFil(KonverterArrangement);

        } catch(ClassNotFoundException | ParseException ps) {
            ps.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void lesFraPersoner(ActionEvent event) throws IOException,ClassNotFoundException {

        ArrayList<String> data = new ArrayList<>();

        try {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            String path = selectedFile.getPath();
            String navn = selectedFile.getName();

            String subString = navn.substring(navn.lastIndexOf("."), navn.length());

            alertbox.godkjent(data.toString());

            fil lesCsv = new csvFil();
            lesCsv.lesCsvFil(path,data);



           /* if (t.equals(".csv")) {
                fil lesCsv = new csvFil();
                lesCsv.lesCsvFil(path,data);
                System.out.println(data.toString());
            } else {
                fil lesJobjFil = new jobjFil();
                lesJobjFil.lesJobjFil(path,data);
            }
            */
        } catch (RuntimeException rt) {
            rt.printStackTrace();
        }
        // TODO implemnter metode for å lese fra JOBJ filer.
        try {

        alertbox.feil(data.toString());

        String ID = data.get(0);
        String fornavn = data.get(1);
        String etternavn = data.get(2);
        String telefon= data.get(3);
        String ePost = data.get(4);
        String nettside = data.get(5);
        String virksomhet = data.get(6);
        String opplysninger = data.get(7);

        Kontaktperson kontaktperson = new Kontaktperson(ID, fornavn, etternavn, telefon, ePost, nettside, virksomhet, opplysninger);

        alertbox.godkjent(kontaktperson.toString());

        ArrayList <Kontaktperson> KonverterKontakperson = new ArrayList<>();
        KonverterKontakperson.add(kontaktperson);
        PersonSerialiser serialiser = new PersonSerialiser();
        serialiser.skrivArrayTilFil(KonverterKontakperson);

        } catch(ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }
    }

}


