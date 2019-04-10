package org.openjfx.logic.exceptions;

public class plasserException extends Exception{
    public String myException(int plasser) {
        return "Det er ikke nok plasser for så mange biletter. Det er kun " + plasser + " plasser igjen";
    }
}
