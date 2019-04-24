package org.openjfx.logic.Lokale;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LokaleValidering {
    public static boolean validerLokale(Lokale lokale) {

        String lokaleId = lokale.getLokaleID();
        Pattern patternLokaleId = Pattern.compile("^[0-9]{1,30}$");
        Matcher matchLokaleId = patternLokaleId.matcher(lokaleId);
        if(!matchLokaleId.matches()) {
            return false;
        }

        String navn = lokale.getNavn();
        Pattern patternNavn = Pattern.compile("^[A-ZÆØÅa-zæøå -]{2,30}$");
        Matcher matchNavn = patternNavn.matcher(navn);
        if(!matchNavn.matches()) {
            return false;
        }

        String type = lokale.getType();
        Pattern patternType = Pattern.compile("^[A-ZÆØÅa-zæøå0-9 -]{2,30}$");
        Matcher matchType = patternType.matcher(type);
        if(!matchType.matches()) {
            return false;
        }

        int plasser = lokale.getAntallPlasser();
        String plasserString = Integer.toString(plasser);
        Pattern patternPlasser = Pattern.compile("^[0-9]$");
        Matcher matchPlasser = patternPlasser.matcher(plasserString);
        if(!matchPlasser.matches()) {
            return false;
        }

        return true;
    }
}
