package org.openjfx.logic.Filhåndtering;


import java.util.ArrayList;

public abstract class fil {

    public abstract ArrayList<String> lesCsvFil(String path, ArrayList<String> data);
    public abstract ArrayList<String>  lesJobjFil(String path, ArrayList<String> data);

}


