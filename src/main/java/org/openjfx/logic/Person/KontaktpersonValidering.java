package org.openjfx.logic.Person;

import javafx.css.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KontaktpersonValidering {

    public static boolean validerKontaktperson(Kontaktperson kontaktperson) {

        String kontaktPersonID = kontaktperson.getKontaktpersonID();
        Pattern patternPersonID = Pattern.compile("^[0-9]$");
        Matcher matchPersonID = patternPersonID.matcher(kontaktPersonID);
        if(!matchPersonID.matches()) {
            return false;
        }

        String fornavn = kontaktperson.getFornavn();
        Pattern patternFornavn = Pattern.compile("^[A-ZÆØÅa-zæøå -]{2,20}$");
        Matcher matchFornavn = patternFornavn.matcher(fornavn);
        if(!matchFornavn.matches()) {
            return false;
        }

        String etternavn = kontaktperson.getEtternavn();
        Pattern patternEtternavn = Pattern.compile("^[A-ZÆØÅa-zæøå -]{2,30}$");
        Matcher matchEtternavn = patternEtternavn.matcher(etternavn);
        if(!matchEtternavn.matches()) {
            return false;
        }

        String tlf = kontaktperson.getTelefon();
        Pattern patternTlf = Pattern.compile("^[0-9]{8}$");
        Matcher matchTlf = patternTlf.matcher(tlf);
        if(!matchTlf.matches()) {
            return false;
        }

        String epost = kontaktperson.getEpost();
        Pattern patternEpost = Pattern.compile("^[A-Za-z0-9@.-]{5,30}$");
        Matcher matchEpost = patternEpost.matcher(epost);
        if(!matchEpost.matches()) {
            return false;
        }


        return true;
    }

}
