package org.openjfx.logic.Filhåndtering;

import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.filException;
import org.openjfx.logic.exceptions.inputException;
import org.openjfx.logic.exceptions.kodesprakException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class skrivTilCsv extends skrivTilFil{

    @Override
    public void skrivTilCsv(ArrayList data, String path) {
        PrintWriter skriver = null;

        try {
            skriver = new PrintWriter(path, StandardCharsets.UTF_8);

            for(Object info : data) {
                skriver.println(info);
            }
        } catch(FileNotFoundException fnf) {
           alertbox.feil(filException.filException());
        } catch(UnsupportedEncodingException ue) {
            alertbox.feil(kodesprakException.kodesprakException());
        } catch(IOException io) {
           alertbox.feil(inputException.ioException());
        } finally {
            if(skriver != null) {
                skriver.close();
            }
        }
    }

    @Override
    public void skrivTilJobj(ArrayList data, String path) {

    }
}
