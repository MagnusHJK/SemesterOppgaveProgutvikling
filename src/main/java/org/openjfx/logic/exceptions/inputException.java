package org.openjfx.logic.exceptions;

public class inputException extends Exception{


    public static String txtException(String tekst) {
        return "Hele input-feltet er nødt til å være tekst, dette er feil: " + tekst;
    }

    public static String intException(String tekst) {
        return "input-feltet må bestå av heltall, dette er feil: " + tekst;
    }
}
