package org.openjfx.logic.exceptions;

public class idException extends Exception{
    public static String myException (String id) {
        return "Id nr." + id + " er allerede brukt";
    }
}
