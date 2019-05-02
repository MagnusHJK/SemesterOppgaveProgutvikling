package org.openjfx.logic.Filhåndtering;

import java.io.File;
import java.util.ArrayList;

public class velgFil {

    public static void velgFil(String navn, String path, ArrayList<String> data) {

        String subString = navn.substring(navn.lastIndexOf("."), navn.length());
        if (subString.equals(".csv")) {
            fil lesCsv = new csvFil();
            lesCsv.lesCsvFil(path,data);
        } else {
            fil lesJobjFil = new jobjFil();
            lesJobjFil.lesJobjFil(path,data);
        }
    }
}
