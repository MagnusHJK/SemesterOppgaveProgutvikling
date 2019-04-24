package org.openjfx.logic.Arrangement;

//import java.util.Scanner;

import javafx.css.Match;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrangementValidering {

    public static boolean valider(Arrangement arrangement) {
        String navn = arrangement.getNavn();
        Pattern patternNavn = Pattern.compile("^[A-ZÆØÅa-zæøå ]{2,30}$");
        Matcher matchNavn = patternNavn.matcher(navn);
        if(matchNavn.matches()) {
            return true;
        }
        String artist = arrangement.getArtist();
        Matcher matchArtist = patternNavn.matcher(artist);
        if(matchArtist.matches()) {
            return true;
        }
        String sted = arrangement.getSted();
        Pattern patternSted = Pattern.compile("^[A-ZÆØÅa-zæøå ]{2,30}$");
        Matcher matchSted = patternSted.matcher(sted);
        if(matchSted.matches()) {
            return true;
        }
        String beskrivelse = arrangement.getBeskrivelse();
        Pattern patternBeskrivelse = Pattern.compile("^[A-ZÆØÅa-zæøå0-9 ./-]");
        Matcher matchBeskrivelse = patternBeskrivelse.matcher(beskrivelse);
        if(matchBeskrivelse.matches()) {
            return true;
        }
        int billettPris = arrangement.getBillettPris();
        String prisSomString = Integer.toString(billettPris);
        Pattern patternBillettPris = Pattern.compile("^[0-9.]");
        Matcher matchBillettPris = patternBillettPris.matcher(prisSomString);
        if(matchBillettPris.matches()) {
            return true;
        }
        return false;
    }

  /*  public static String txtvalid(String tekst) {
        Pattern patternNavn = Pattern.compile("^[A-ZÆØÅa-zæøå ]{2,30}$");
        Matcher match = patternNavn.matcher(tekst);
        return match + " er gyldig";
    }
*/
}
