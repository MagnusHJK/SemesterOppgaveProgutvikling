package org.openjfx.logic.Arrangement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Billett.Billett;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Arrangement implements Serializable {
    private String arrangementID;
    private Kontaktperson kontaktperson;            //Kontaktperson
    private Lokale type;                            //Type feks Kinosal, teater, etx
    private String navn;              //Navn på hendelse
    private String artist;            //Headliner
    private String sted;              //Lokasjon feks Uttestad
    private LocalDate dato;
    private String tidspunkt;
    private String beskrivelse;       //Tekst beskrivelse av arrangement
    private int billettPris;      //Billett pris
    private int billettMaks;      //Maks antall billetter
    private Billett[] salg;

    public Arrangement(String arrangementID, Kontaktperson kontaktperson, Lokale type, String navn, String artist,
                       String sted, LocalDate dato, String tidspunkt, String beskrivelse, int billettPris, int billettMaks, Billett[] salg) {

        this.arrangementID = arrangementID;
        this.kontaktperson = kontaktperson;
        this.type = type;
        this.navn = navn;
        this.artist = artist;
        this.sted = sted;
        this.dato = dato;
        this.tidspunkt = tidspunkt;
        this.beskrivelse = beskrivelse;
        this.billettPris = billettPris;
        this.billettMaks = billettMaks;
        this.salg = salg;
    }

    public String getArrangementID() {
        return arrangementID;
    }

    public void setArrangementID(String arrangementID) {
        this.arrangementID = arrangementID;
    }

    public Kontaktperson getKontaktperson() {
        return kontaktperson;
    }

    public void setKontaktperson(Kontaktperson kontaktperson) {
        this.kontaktperson = kontaktperson;
    }

    public Lokale getType() {
        return type;
    }

    public String getTypeString() {
        return type.getType();
    }

    public void setType(Lokale type) {
        this.type = type;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public String getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(String tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public int getBillettPris() {
        return billettPris;
    }

    public void setBillettPris(int billettPris) {
        this.billettPris = billettPris;
    }

    public int getBillettMaks() {
        return billettMaks;
    }

    public void setBillettMaks(int billettMaks) {
        this.billettMaks = billettMaks;
    }

    public Billett[] getSalg() {
        return salg;
    }

    public void setSalg(Billett[] salg) {
        this.salg = salg;
    }


    //get metode for å finne antall solgte billetter for arrangementet
    public ObservableValue<Integer> getSalgAntall(){
        int salgAntall = 0;
        for(int i = 0; i < this.getSalg().length; i++){
            if(this.getSalg()[i] != null){
                salgAntall++;
            }
        }
        ObservableValue<Integer> salgAntallObservable = new SimpleIntegerProperty(salgAntall).asObject();
        return salgAntallObservable;
    }

    @Override
    public String toString() {
        return this.getNavn();
    }


}
