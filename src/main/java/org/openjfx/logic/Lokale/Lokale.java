package org.openjfx.logic.Lokale;


import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Arrangement.Arrangement;

import java.io.Serializable;
import java.util.ArrayList;


public class Lokale implements Serializable {
    private String lokaleID;  //Key for objekt
    private String navn;  //Navn på stedet
    private String type;  //Kinosal, Konsertsal, etc
    private int antallPlasser;


    public Lokale(String lokaleID, String navn, String type, int antallPlasser) {
        this.lokaleID = lokaleID;
        this.navn = navn;
        this.type = type;
        this.antallPlasser = antallPlasser;
    }

    public String getLokaleID() {
        return lokaleID;
    }

    public void setLokaleID(String lokaleID) {
        this.lokaleID = lokaleID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAntallPlasser() {
        return antallPlasser;
    }

    public void setAntallPlasser(int antallPlasser) {
        this.antallPlasser = antallPlasser;
    }

    @Override
    public String toString(){
        return this.getLokaleID() + " - " + this.getType();
    }


    //Lager ObservableList med lokaler som brukes til å populere GUI  -  SKRIV OM SENERE TIL Å LESE FIL
    public static ArrayList<Lokale> lagLokaleList(){
        ArrayList<Lokale> lokaleList = new ArrayList<>();
        lokaleList.add(new Lokale("lokale1", "Ottestad Kino", "Kinosal", 100));
        lokaleList.add(new Lokale("lokale2", "Ottestad Konsert", "Konsertsal", 500));

        return lokaleList;
    }

    public void populerArray(){

    }
}
