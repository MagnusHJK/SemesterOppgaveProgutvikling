package org.openjfx.logic.Arrangement;

//import java.util.Scanner;

import javafx.css.Match;
import javafx.scene.control.Alert;

//import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrangementValidering {

    public static boolean valider(Arrangement arrangement) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");


        String navn = arrangement.getNavn();
        Pattern patternNavn = Pattern.compile("^[A-ZÆØÅa-zæøå ]{2,30}$");
        Matcher matchNavn = patternNavn.matcher(navn);

        String artist = arrangement.getArtist();
        Matcher matchArtist = patternNavn.matcher(artist);

        String sted = arrangement.getSted();
        Pattern patternSted = Pattern.compile("^[A-ZÆØÅa-zæøå ]{2,30}$");
        Matcher matchSted = patternSted.matcher(sted);

        String beskrivelse = arrangement.getBeskrivelse();
        Pattern patternBeskrivelse = Pattern.compile("^[A-ZÆØÅa-zæøå0-9 ./-]");
        Matcher matchBeskrivelse = patternBeskrivelse.matcher(beskrivelse);

        int billettPris = arrangement.getBillettPris();
        String prisSomString = Integer.toString(billettPris);
        Pattern patternBillettPris = Pattern.compile("^[0-9.]");
        Matcher matchBillettPris = patternBillettPris.matcher(prisSomString);


        if(matchNavn.matches()) {
            return true;

        } else if(matchArtist.matches()) {
            return true;
        } else if(matchSted.matches()) {
            return true;
        } else if(matchBeskrivelse.matches()) {
            return true;
        } else if(matchBillettPris.matches()) {
            return true;
        } else {
            return false;
        }
    }



  /*  public static String txtvalid(String tekst) {
        Pattern patternNavn = Pattern.compile("^[A-ZÆØÅa-zæøå ]{2,30}$");
        Matcher match = patternNavn.matcher(tekst);
        return match + " er gyldig";
    }
*/
}
