package org.openjfx.logic.Person;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.logic.Filhåndtering.skrivTilCsv;
import org.openjfx.logic.Filhåndtering.skrivTilFil;
import org.openjfx.logic.Filhåndtering.velgFil;
import org.openjfx.logic.Filhåndtering.velgFilSkriv;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.exceptions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PersonFilhåndtering {

    public void personLes(){

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
            alertbox.feil(nullException.nullException());
        } catch (RuntimeException rt) {
            alertbox.feil(kjoreException.kjoreException());
        }
        try {

            String ID = data.get(0);
            String fornavn = data.get(1);
            String etternavn = data.get(2);
            String telefon= data.get(3);
            String ePost = data.get(4);
            String nettside = data.get(5);
            String virksomhet = data.get(6);
            String opplysninger = data.get(7);

            Kontaktperson kontaktperson = new Kontaktperson(ID, fornavn, etternavn, telefon, ePost, nettside, virksomhet, opplysninger);

            PersonSerialiser serialiser = new PersonSerialiser();
            ArrayList<Kontaktperson> liste = serialiser.lesArrayFraFil();
            liste.add(kontaktperson);

            serialiser.skrivArrayTilFil(liste);

        } catch(NumberFormatException nfe) {
            alertbox.feil(tallFormatException.tallFormatException());
        } catch (ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        } catch(IndexOutOfBoundsException iob) {
            alertbox.feil(rekkeviddeException.rekkeviddeException());
        } catch (IOException ioe){
            alertbox.feil(inputException.ioException());
        }
    }

    public void personSkriv(){
        try {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            String path = selectedFile.getPath();
            String navn = selectedFile.getName();
            ArrayList<String> data = new ArrayList<>();

            try {
                velgFilSkriv.velgFilSkriv(navn, path, data, "databases/person.txt");
            } catch (RuntimeException rt) {
                alertbox.feil(kjoreException.kjoreException());
            }
        } catch (NullPointerException npe) {
            alertbox.feil(nullException.nullException());
        }
    }
}
