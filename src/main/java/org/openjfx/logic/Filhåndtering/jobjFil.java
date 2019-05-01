package org.openjfx.logic.Filhåndtering;

import org.openjfx.logic.exceptions.alertbox;

import java.util.ArrayList;

public class jobjFil extends fil{
    @Override
    public String lesJobjFil(String path, ArrayList<String> data)  {
        alertbox.godkjent("Du skal nå lese en jobj fil");

        return "hei";
    }

    @Override
    public ArrayList<String> lesCsvFil(String path, ArrayList<String> data) {
        return data;
    }
}
