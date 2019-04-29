package org.openjfx.logic.Person;

import javafx.css.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KontaktpersonValidering {

    public static boolean validerKontaktperson(Kontaktperson kontaktperson) {

        String kontaktPersonID = kontaktperson.getPersonID();
        Pattern patternPersonID = Pattern.compile("^[0-9]$");
        Matcher matchPersonID = patternPersonID.matcher(kontaktPersonID);
        if(matchPersonID.matches()) {
            return true;
        }

        String fornavn = kontaktperson.getFornavn();
        Pattern patternFornavn = Pattern.compile("^[A-ZÆØÅa-zæøå -]{2,20}$");
        Matcher matchFornavn = patternFornavn.matcher(fornavn);
        if(matchFornavn.matches()) {
            return true;
        }

        String etternavn = kontaktperson.getEtternavn();
        Pattern patternEtternavn = Pattern.compile("^[A-ZÆØÅa-zæøå -]{2,30}$");
        Matcher matchEtternavn = patternEtternavn.matcher(etternavn);
        if(matchEtternavn.matches()) {
            return true;
        }

        String tlf = kontaktperson.getTelefon();
        Pattern patternTlf = Pattern.compile("^[0-9]{8}$");
        Matcher matchTlf = patternTlf.matcher(tlf);
        if(matchTlf.matches()) {
            return true;
        }

        String epost = kontaktperson.getEpost();
        Pattern patternEpost = Pattern.compile("^[A-Za-z0-9@.-]{5,30}$");
        Matcher matchEpost = patternEpost.matcher(epost);
        if(matchEpost.matches()) {
            return true;
        }

        String nettside = kontaktperson.getNettside();
        Pattern patternNettside = Pattern.compile("^[A-ZÆØÅa-zæøå0-9.-/]{4,30}");
        Matcher matchNettside = patternNettside.matcher(nettside);
        if(matchNettside.matches()) {
            return true;
        }

        String virksomhet = kontaktperson.getVirksomhet();
        Pattern patternVirksomhet = Pattern.compile("^[A-Za-z ]{4,30}");
        Matcher matchVirksomhet = patternVirksomhet.matcher(virksomhet);
        if(matchVirksomhet.matches()) {
            return true;
        }

        String opplysninger = kontaktperson.getOpplysninger();
        Pattern patternOpplysninger = Pattern.compile("^[A-Za-z0-9. ]{4,30}");
        Matcher matchOpplysninger = patternOpplysninger.matcher(opplysninger);
        if(matchOpplysninger.matches()) {
            return true;
        }


        return false;
    }

}
