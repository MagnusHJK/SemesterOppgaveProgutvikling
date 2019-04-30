package org.openjfx.logic.Filhåndtering;

import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;

import java.util.ArrayList;

public abstract class skrivTilFil {

    public abstract void LokaleTilCsv(ArrayList<Lokale> lokale, String path);
    public abstract void ArrangementTilCsv(ArrayList<Arrangement> arrangement, String path);
    public abstract void PersonTilCsv(ArrayList<Kontaktperson> person, String path);
}
