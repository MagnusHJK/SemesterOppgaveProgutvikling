package org.openjfx.logic.Filhåndtering;

import java.util.ArrayList;

public class velgFilSkriv {
    public static void velgFilSkriv(String navn, String path, ArrayList<String> data) {

        String subString = navn.substring(navn.lastIndexOf("."), navn.length());
        if (subString.equals(".csv")) {
            skrivTilFil skrivTilCsv = new skrivTilCsv();
            skrivTilCsv.skrivTilCsv(data,path);
        } else {
            skrivTilFil skrivTilJobj = new skriTilJobj();
            skrivTilJobj.skrivTilJobj(data,path);
        }
    }
}
