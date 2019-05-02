package org.openjfx.logic.Filhåndtering;

import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;

import java.util.ArrayList;

public abstract class skrivTilFil {

    public abstract void skrivTilCsv(ArrayList data, String path);

    public abstract void skrivTilJobj(ArrayList data, String path);
}
