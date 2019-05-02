package org.openjfx.logic.Person;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.logic.Filhåndtering.skrivTilCsv;
import org.openjfx.logic.Filhåndtering.skrivTilFil;
import org.openjfx.logic.Filhåndtering.velgFil;
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

        } catch(NumberFormatException nfe) {
            alertbox.feil(tallFormatException.tallFormatException());
        } catch (ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }catch (IOException ioe){
            alertbox.feil(inputException.ioException());
        }
    }

    public void personSkriv(){
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv", "*.obj"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        String path = selectedFile.getPath();

        PersonSerialiser personSerialiser = new PersonSerialiser();

        skrivTilFil skriv = new skrivTilCsv();
        try{
            skriv.PersonTilCsv(personSerialiser.lesArrayFraFil(),path);
        } catch (IOException io) {
            alertbox.feil(inputException.ioException());
        } catch(ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }
    }
}
