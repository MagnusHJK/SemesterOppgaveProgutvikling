package org.openjfx.logic.Person;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;

public class Kontaktperson extends Person implements Serializable {
    private String epost;
    private String nettside;
    private String virksomhet;
    private String opplysninger;

    public Kontaktperson(String personID, String fornavn, String etternavn, String telefon, String epost, String nettside, String virksomhet, String opplysninger) {
        super(personID, fornavn, etternavn, telefon);
        this.epost = epost;
        this.nettside = nettside;
        this.virksomhet = virksomhet;
        this.opplysninger = opplysninger;
    }


    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public String getNettside() {
        return nettside;
    }

    public void setNettside(String nettside) {
        this.nettside = nettside;
    }

    public String getVirksomhet() {
        return virksomhet;
    }

    public void setVirksomhet(String virksomhet) {
        this.virksomhet = virksomhet;
    }

    public String getOpplysninger() {
        return opplysninger;
    }

    public void setOpplysninger(String opplysninger) {
        this.opplysninger = opplysninger;
    }

    public String toString(){
        return this.getFornavn() + " " + this.getEtternavn();
    }

    public static ArrayList<Kontaktperson> lagKontaktpersonListe(){
        ArrayList<Kontaktperson>kontaktpersonListe = new ArrayList<>();

        kontaktpersonListe.add(new Kontaktperson("Dest23","Magnus", "Hjelmen", "91994468",
                "Magnus@email.com", "example.com", "Google", "I am very cool"));

        kontaktpersonListe.add(new Kontaktperson("LDKFG445","Tonje", "Pettersen", "12345678",
                "Tonje@email.com", "example.com", "Microsoft", "Jag är från sverige"));


        return kontaktpersonListe;
    }

}
