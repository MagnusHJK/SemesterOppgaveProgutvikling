package org.openjfx.logic.exceptions;

public class inputException extends Exception{


    public static String emptyException() {
        return "Alle input-feltene mp være fyllt ut";
    }

    public static String intException() {
        return "input-feltet må bestå av heltall";
    }

    public static String nullexception() { return "Nedtrekksmenyene er nødt til å være fyllt ut"; }
}
