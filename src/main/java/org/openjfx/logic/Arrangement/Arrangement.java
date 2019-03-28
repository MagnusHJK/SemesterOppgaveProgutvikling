package org.openjfx.logic.Arrangement;

import org.openjfx.logic.Person.Kontaktperson;

public class Arrangement {
    private Kontaktperson kontaktperson;
    private String type;
    private String navn;
    private String artist;
    private String sted;
    private int billettPris;
    private int billettMaks;

    public Arrangement(Kontaktperson kontaktperson, String type, String navn, String artist, String sted, int billettPris, int billettMaks) {
        this.kontaktperson = kontaktperson;
        this.type = type;
        this.navn = navn;
        this.artist = artist;
        this.sted = sted;
        this.billettPris = billettPris;
        this.billettMaks = billettMaks;
    }

    //Legger et spesifikt arrangement til i database txt fila
    public boolean leggTilArrangement(Arrangement arrangement){
        return true;
    }


    //Endrer et spesifikt arrangement
    public boolean endreArrangement(Arrangement arrangement){
        return true;
    }

}
