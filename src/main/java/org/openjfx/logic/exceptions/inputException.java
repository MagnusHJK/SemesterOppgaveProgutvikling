package org.openjfx.logic.exceptions;

public class inputException {


    public String txtException(String tekst) {
        return "Hele input-feltet er nødt til å være tekst, dette er feil: " + tekst;
    }

    public String intException(int tall) {
        return "input-feltet må bestå av heltall, dette er feil: " + tall;
    }
}
