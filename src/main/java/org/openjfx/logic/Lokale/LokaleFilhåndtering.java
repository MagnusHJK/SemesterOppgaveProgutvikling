package org.openjfx.logic.Lokale;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.logic.Filhåndtering.skrivTilCsv;
import org.openjfx.logic.Filhåndtering.skrivTilFil;
import org.openjfx.logic.Filhåndtering.velgFil;
import org.openjfx.logic.Filhåndtering.velgFilSkriv;
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
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        } catch (RuntimeException rt) {
            alertbox.feil(kjoreException.kjoreException());
        }

        try {
            String ID = data.get(0);
            String navn = data.get(1);
            String type = data.get(2);
            int plasser = Integer.parseInt(data.get(3));

            Lokale lokale = new Lokale(ID,navn,type,plasser);

            LokaleSerialiser serialiser = new LokaleSerialiser();
            ArrayList<Lokale> liste = serialiser.lesArrayFraFil();
            liste.add(lokale);
            
            serialiser.skrivArrayTilFil(liste);

        } catch(NumberFormatException nfe) {
            alertbox.feil(tallFormatException.tallFormatException());
        } catch(IndexOutOfBoundsException iob) {
            alertbox.feil(rekkeviddeException.rekkeviddeException());
        }  catch (ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }catch (IOException ioe){
            alertbox.feil(inputException.ioException());
        }
    }

    public void lokaleSkriv(){
        try {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            String path = selectedFile.getPath();
            String navn = selectedFile.getName();
            ArrayList<String> data = new ArrayList<>();

            try {
                velgFilSkriv.velgFilSkriv(navn, path, data, "databases/lokale.txt");
            } catch (RuntimeException rt) {
                alertbox.feil(kjoreException.kjoreException());
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }
}
