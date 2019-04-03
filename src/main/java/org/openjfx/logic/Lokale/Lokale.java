package org.openjfx.logic.Lokale;


import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Arrangement.Arrangement;


public class Lokale {
    private SimpleStringProperty lokaleID;  //Key for objekt
    private SimpleStringProperty navn;  //Navn på stedet
    private SimpleStringProperty type;  //Kinosal, Konsertsal, etc
    private SimpleIntegerProperty antallPlasser;


    public Lokale(String lokaleID, String navn, String type, int antallPlasser) {
        this.lokaleID = new SimpleStringProperty(lokaleID);
        this.navn = new SimpleStringProperty(navn);
        this.type = new SimpleStringProperty(type);
        this.antallPlasser = new SimpleIntegerProperty(antallPlasser);
    }

    public String getLokaleID() {
        return lokaleID.get();
    }

    public SimpleStringProperty lokaleIDProperty() {
        return lokaleID;
    }

    public void setLokaleID(String lokaleID) {
        this.lokaleID.set(lokaleID);
    }

    public String getNavn() {
        return navn.get();
    }

    public SimpleStringProperty navnProperty() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn.set(navn);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public int getAntallPlasser() {
        return antallPlasser.get();
    }

    public SimpleIntegerProperty antallPlasserProperty() {
        return antallPlasser;
    }

    public void setAntallPlasser(int antallPlasser) {
        this.antallPlasser.set(antallPlasser);
    }


    @Override
    public String toString(){
        return this.getType();
    }


    //Lager ObservableList med lokaler som brukes til å populere GUI  -  SKRIV OM SENERE TIL Å LESE FIL
    public static ObservableList<Lokale> lagLokaleList(){
        ObservableList<Lokale> lokaleList = FXCollections.observableArrayList();
        lokaleList.add(new Lokale("lokale1", "Ottestad Kino", "Kinosal", 100));
        lokaleList.add(new Lokale("lokale2", "Ottestad Konsert", "Konsertsal", 500));

        return lokaleList;
    }


    public void populerArray(){

    }
}
