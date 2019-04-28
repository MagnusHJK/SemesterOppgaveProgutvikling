package org.openjfx.logic.Arrangement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;

import java.io.*;
import java.util.ArrayList;

public class Arrangement implements Serializable {
    private String arrangementID;
    private Kontaktperson kontaktperson;            //Kontaktperson
    private Lokale type;                            //Type feks Kinosal, teater, etx
    private String navn;              //Navn på hendelse
    private String artist;            //Headliner
    private String sted;              //Lokasjon feks Uttestad
    private String beskrivelse;       //Tekst beskrivelse av arrangement
    private int billettPris;      //Billett pris
    private int billettMaks;      //Maks antall biletter

    public Arrangement(String arrangementID, Kontaktperson kontaktperson, Lokale type, String navn, String artist, String sted, String beskrivelse, int billettPris, int billettMaks) {
        this.arrangementID = arrangementID;
        this.kontaktperson = kontaktperson;
        this.type = type;
        this.navn = navn;
        this.artist = artist;
        this.sted = sted;
        this.beskrivelse = beskrivelse;
        this.billettPris = billettPris;
        this.billettMaks = billettMaks;
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

    @Override
    public String toString() {
        return this.getNavn() + " " + this.getType() + " " + this.getKontaktperson();
    }



    //Lager midlertidig statisk Arrangement liste, husk å konverter til ObservableList før du bruker i JavaFX
    public static ArrayList<Arrangement> lagArrangementListe(){
        ArrayList<Arrangement>arrangementListe = new ArrayList<>();

        arrangementListe.add(new Arrangement("adaw2", Kontaktperson.lagKontaktpersonListe().get(0), Lokale.lagLokaleList().get(0),
                "La La Land", "Emma Stone", "Ottestad", "Sykt bra film.", 100, 69));

        arrangementListe.add(new Arrangement("Dwad3", Kontaktperson.lagKontaktpersonListe().get(1), Lokale.lagLokaleList().get(1),
                "Cats", "Gunnar", "Ottestad", "Sykt kule katter", 250, 100));


        return arrangementListe;
    }



   /*
   public static ObservableList<Arrangement> lagArrangementListe() {
        ObservableList<Arrangement> arrangementListe = FXCollections.observableArrayList();

        arrangementListe.add(new Arrangement("adaw2", Kontaktperson.lagKontaktpersonListe().get(0),
                Lokale.lagLokaleList().get(0), "La La Land", "Emma Stone",
                "Ottestad", "Sykt bra film.", 100, 69));

        arrangementListe.add(new Arrangement("Dwad3", Kontaktperson.lagKontaktpersonListe().get(1),
                Lokale.lagLokaleList().get(1), "Cats", "Gunnar", "Ottestad",
                "Sykt kule katter", 250, 100));

        return arrangementListe;
    }
    */
}
