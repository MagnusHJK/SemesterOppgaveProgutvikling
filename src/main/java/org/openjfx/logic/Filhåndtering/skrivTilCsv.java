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
    public void LokaleTilCsv(ArrayList<Lokale> lokale, String path) {
        PrintWriter skriver = null;

        try {
            skriver = new PrintWriter(path, StandardCharsets.UTF_8);

            for(Lokale lokaler : lokale) {
                skriver.println(lokaler);
            }
        } catch(FileNotFoundException | UnsupportedEncodingException ue) {
            ue.printStackTrace();
        } catch(IOException io) {
            io.printStackTrace();
        } finally {
            if(skriver != null) {
                skriver.close();
            }
        }
    }

    @Override
    public void ArrangementTilCsv(ArrayList<Arrangement> arrangement, String path) {
        PrintWriter skriver = null;

        try {
            skriver = new PrintWriter(path, StandardCharsets.UTF_8);

            for(Arrangement arrangementer : arrangement) {
                skriver.println(arrangementer);
            }
        } catch(FileNotFoundException | UnsupportedEncodingException ue) {
            ue.printStackTrace();
        } catch(IOException io) {
            io.printStackTrace();
        } finally {
            if(skriver != null) {
                skriver.close();
            }
        }
    }

    @Override
    public void PersonTilCsv(ArrayList<Kontaktperson> person , String path) {
        PrintWriter skriver = null;

        try {
            skriver = new PrintWriter(path, StandardCharsets.UTF_8);

            for(Kontaktperson personer : person) {
                skriver.println(personer);
            }
        } catch(FileNotFoundException fnf) {
            alertbox.feil(filException.filException());
        } catch(UnsupportedEncodingException ue) {
            alertbox.feil(kodesprakException.kodesprakException());
        }catch(IOException io) {
          alertbox.feil(inputException.ioException());
        } finally {
            if(skriver != null) {
                skriver.close();
            }
        }
    }

    @Override
    public void LokaleTiljobj(ArrayList<Lokale> lokale, String path) {

    }

    @Override
    public void ArrangementTilJobj(ArrayList<Arrangement> arrangement, String path) {

    }

    @Override
    public void PersonTilJobj(ArrayList<Kontaktperson> person, String path) {

    }


}
