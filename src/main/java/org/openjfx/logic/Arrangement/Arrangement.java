package org.openjfx.logic.Arrangement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;

public class Arrangement {
    private Kontaktperson kontaktperson;
    private SimpleStringProperty type;
    private SimpleStringProperty navn;
    private SimpleStringProperty artist;
    private SimpleStringProperty sted;
    private SimpleStringProperty beskrivelse;       //Tekst beskrivelse av arrangement
    private SimpleIntegerProperty billettPris;      //Billett pris
    private SimpleIntegerProperty billettMaks;      //Maks antall biletter


    public Arrangement(Kontaktperson kontaktperson, String type, String navn, String artist, String sted, String beskrivelse, int billettPris, int billettMaks) {
        this.kontaktperson = kontaktperson;
        this.type = new SimpleStringProperty(type);
        this.navn = new SimpleStringProperty(navn);
        this.artist = new SimpleStringProperty(artist);
        this.sted = new SimpleStringProperty(sted);
        this.beskrivelse = new SimpleStringProperty(beskrivelse);
        this.billettPris = new SimpleIntegerProperty(billettPris);
        this.billettMaks = new SimpleIntegerProperty(billettMaks);
    }

    public Kontaktperson getKontaktperson() {
        return kontaktperson;
    }

    public void setKontaktperson(Kontaktperson kontaktperson) {
        this.kontaktperson = kontaktperson;
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

    public String getNavn() {
        return navn.get();
    }

    public SimpleStringProperty navnProperty() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn.set(navn);
    }

    public String getArtist() {
        return artist.get();
    }

    public SimpleStringProperty artistProperty() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }

    public String getSted() {
        return sted.get();
    }

    public SimpleStringProperty stedProperty() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted.set(sted);
    }

    public String getBeskrivelse() {
        return beskrivelse.get();
    }

    public SimpleStringProperty beskrivelseProperty() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse.set(beskrivelse);
    }

    public int getBillettPris() {
        return billettPris.get();
    }

    public SimpleIntegerProperty billettPrisProperty() {
        return billettPris;
    }

    public void setBillettPris(int billettPris) {
        this.billettPris.set(billettPris);
    }

    public int getBillettMaks() {
        return billettMaks.get();
    }

    public SimpleIntegerProperty billettMaksProperty() {
        return billettMaks;
    }

    public void setBillettMaks(int billettMaks) {
        this.billettMaks.set(billettMaks);
    }

    //Lager ObservableList med Arrangementer som brukes til å populere GUI  -  SKRIV OM SENERE TIL Å LESE ARRAY FRA lagArrayFraFil()
    public static ObservableList<Arrangement> lagArrangementListe(){
        ObservableList<Arrangement>ArrangementList = FXCollections.observableArrayList();


        ArrangementList.add(new Arrangement(Kontaktperson.lagKontaktpersonListe().get(0), "Kinosal",
                "La La Land", "Emma Stone", "Ottestad", "Sykt bra film.", 100, 69));


        ArrangementList.add(new Arrangement(Kontaktperson.lagKontaktpersonListe().get(1), "Konsertsal",
                "Cats", "Gunnar", "Ottestad", "Sykt kule katter", 250, 100));


        return ArrangementList;
    }



    //Lager et array fra innlest serialisert fil, brukes senere til å populere GUI via lagArrangementListe()
    public void lagArrayFraFil(){

    }

    //Legger et spesifikt arrangement
    public boolean leggTilArrangement(Arrangement arrangement){
        return true;
    }


    //Endrer et spesifikt arrangement
    public boolean endreArrangement(Arrangement arrangement){
        return true;
    }

}
