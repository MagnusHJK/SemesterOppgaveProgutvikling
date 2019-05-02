package org.openjfx.logic.Lokale;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.logic.Filhåndtering.skrivTilCsv;
import org.openjfx.logic.Filhåndtering.skrivTilFil;
import org.openjfx.logic.Filhåndtering.velgFil;
import org.openjfx.logic.exceptions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LokaleFilhåndtering {

    public void lokaleLes(){
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
        }catch (IOException ioe){
            alertbox.feil(inputException.ioException());
        }
    }

    public void lokaleSkriv(){
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        String path = selectedFile.getPath();

        LokaleSerialiser lokaleSerialiser = new LokaleSerialiser();

        skrivTilFil skriv = new skrivTilCsv();
        try{
            skriv.LokaleTilCsv(lokaleSerialiser.lesArrayFraFil(),path);
        } catch (IOException io) {
            alertbox.feil(inputException.ioException());
        } catch(ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }
    }
}
