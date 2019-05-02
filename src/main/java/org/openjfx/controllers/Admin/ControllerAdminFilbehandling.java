package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Billett.Billett;
import org.openjfx.logic.Filhåndtering.csvFil;
import org.openjfx.logic.Filhåndtering.jobjFil;
import org.openjfx.logic.Filhåndtering.velgFil;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleHåndtering;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonHåndtering;
import org.openjfx.logic.Person.PersonSerialiser;
import org.openjfx.logic.exceptions.*;
import org.openjfx.logic.Filhåndtering.fil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

            velgFil.velgFil(navn,path,data);
        } catch (RuntimeException rt) {
            alertbox.feil(kjoreException.kjoreException());
        }

        try {
            String ID = data.get(0);
            String navn = data.get(1);
            String type = data.get(2);
            int plasser = Integer.parseInt(data.get(3));

            Lokale lokale = new Lokale(ID,navn,type,plasser);

            ArrayList<Lokale> KonverterLokale = new ArrayList<>();
            KonverterLokale.add(lokale);

            LokaleSerialiser serialiser = new LokaleSerialiser();
            serialiser.skrivArrayTilFil(KonverterLokale);

        } catch(NumberFormatException nfe) {
            alertbox.feil(tallFormatException.tallFormatException());
        } catch (ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }
    }

    public void lesFraArrangement(ActionEvent event) throws IOException{

        ArrayList<String> data = new ArrayList<>();


        try {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            String path = selectedFile.getPath();
            String navn = selectedFile.getName();

            velgFil.velgFil(navn,path,data);
        } catch(RuntimeException rt) {
            alertbox.feil(kjoreException.kjoreException());
        }

        try {

            DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Legger til standardverdi for både kontakperson og lokale, dette er nødt til å endres på senere!
            Kontaktperson kontakperson = new Kontaktperson(
                    "MaHan","Martin","Johansen","12312334",
                    "Martin@Hotmail.com", "eksempel.com","Google","Admin");

            Lokale lokale = new Lokale("100","endre","endre",100);

            String ID = data.get(0);
            String navn= data.get(1);
            String artist = data.get(2);
            String sted = data.get(3);
            String datoTekst = data.get(4);
            LocalDate dato = LocalDate.parse(datoTekst,formater);
            String tidspunkt = data.get(5);
            String beskrivelse = data.get(6);
            int billettPris = Integer.parseInt(data.get(7));
            int billettMaks = Integer.parseInt(data.get(8));
            Billett[] billetter = new Billett[billettMaks];

            Arrangement arrangement = new Arrangement(ID,kontakperson,lokale,navn,artist,sted,dato,tidspunkt,beskrivelse,billettPris,billettMaks,billetter);

            ArrayList <Arrangement> KonverterArrangement = new ArrayList<>();
            KonverterArrangement.add(arrangement);
            ArrangementSerialiser serialiser = new ArrangementSerialiser();
            serialiser.skrivArrayTilFil(KonverterArrangement);

        } catch(ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        } catch(DateTimeParseException dtp) {
            alertbox.feil(datoException.datoException());
        }
    }

    public void lesFraPersoner(ActionEvent event) throws IOException {

        ArrayList<String> data = new ArrayList<>();

        try {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            String path = selectedFile.getPath();
            String navn = selectedFile.getName();

            velgFil.velgFil(navn,path,data);

        } catch (RuntimeException rt) {
            alertbox.feil(kjoreException.kjoreException());
        }
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
            alertbox.feil(klasseException.klasseException());
        }
    }

}


