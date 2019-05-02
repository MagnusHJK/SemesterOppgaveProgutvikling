package org.openjfx.logic.Arrangement;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.logic.Billett.Billett;
import org.openjfx.logic.Filhåndtering.skrivTilCsv;
import org.openjfx.logic.Filhåndtering.skrivTilFil;
import org.openjfx.logic.Filhåndtering.velgFil;
import org.openjfx.logic.Filhåndtering.velgFilSkriv;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.exceptions.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class ArrangementFilhåndtering {
    public void arrangementLes() {

        ArrayList<String> data = new ArrayList<>();


        try {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            String path = selectedFile.getPath();
            String navn = selectedFile.getName();

            velgFil.velgFil(navn, path, data);
        } catch (NullPointerException npe) {
            alertbox.feil(nullException.nullException());
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

            ArrangementSerialiser serialiser = new ArrangementSerialiser();
            ArrayList<Arrangement> liste = serialiser.lesArrayFraFil();
            liste.add(arrangement);

            serialiser.skrivArrayTilFil(liste);

        } catch(NumberFormatException nfe) {
            alertbox.feil(tallFormatException.tallFormatException());
        } catch(IndexOutOfBoundsException iob) {
            alertbox.feil(rekkeviddeException.rekkeviddeException());
        } catch (ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }catch (IOException ioe){
            alertbox.feil(inputException.ioException());
        }
    }

    public void arrangementSkriv(){
        try {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            String path = selectedFile.getPath();
            String navn = selectedFile.getName();
            ArrayList<String> data = new ArrayList<>();

            try {
                velgFilSkriv.velgFilSkriv(navn, path, data, "databases/arrangement.txt");
            } catch (RuntimeException rt) {
                alertbox.feil(kjoreException.kjoreException());
            }
        } catch (NullPointerException npe) {
          alertbox.feil(nullException.nullException());
        }
    }
}
