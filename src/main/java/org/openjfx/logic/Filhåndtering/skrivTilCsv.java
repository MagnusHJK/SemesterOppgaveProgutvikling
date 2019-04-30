package org.openjfx.logic.Filhåndtering;

import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class skrivTilCsv extends skrivTilFil{

    @Override
    public void LokaleTilCsv(ArrayList<Lokale> lokale, String path) {
        PrintWriter skriver = null;

        try {
            skriver = new PrintWriter(path,"UTF_8");

            for(Lokale lokaler : lokale) {
                skriver.println(lokaler);
            }
        } catch(FileNotFoundException | UnsupportedEncodingException ue) {
            ue.printStackTrace();
        } finally {
            if(skriver != null) {
                skriver.close();
            }
        }
    }

    @Override
    public void ArrangementTilCsv(ArrayList<Arrangement> arrangement, String path) {

    }

    @Override
    public void PersonTilCsv(ArrayList<Kontaktperson> person , String path) {

    }


}
