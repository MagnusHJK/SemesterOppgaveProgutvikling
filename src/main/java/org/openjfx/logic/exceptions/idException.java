package org.openjfx.logic.exceptions;

public class idException extends Exception{

    // Parameteren skal være id'en som brukeren ville bruke
    public String myException (int id) {
        return "Id nr." + id + " er allerede brukt";
    }
}
