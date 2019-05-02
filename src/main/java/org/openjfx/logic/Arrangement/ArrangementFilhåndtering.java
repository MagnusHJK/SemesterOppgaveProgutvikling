package org.openjfx.logic.Arrangement;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.logic.Billett.Billett;
import org.openjfx.logic.Filhåndtering.skrivTilCsv;
import org.openjfx.logic.Filhåndtering.skrivTilFil;
import org.openjfx.logic.Filhåndtering.velgFil;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.exceptions.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class ArrangementFilhåndtering {
    public void arrangementLes(){

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

        } catch(NumberFormatException nfe) {
            alertbox.feil(tallFormatException.tallFormatException());
        } catch (ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }catch (IOException ioe){
            alertbox.feil(inputException.ioException());
        }
    }

    public void arrangementSkriv(){
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        String path = selectedFile.getPath();

        ArrangementSerialiser arrangementSerialiser = new ArrangementSerialiser();

        skrivTilFil skriv = new skrivTilCsv();
        try{
            skriv.ArrangementTilCsv(arrangementSerialiser.lesArrayFraFil(),path);
        } catch (IOException io) {
            alertbox.feil(inputException.ioException());
        } catch(ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }
    }
}
