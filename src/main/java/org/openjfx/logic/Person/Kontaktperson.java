package org.openjfx.logic.Person;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Kontaktperson extends Person {
    private transient SimpleStringProperty epost;
    private transient SimpleStringProperty nettside;
    private transient SimpleStringProperty virksomhet;
    private transient SimpleStringProperty opplysninger;

    public Kontaktperson(String fornavn, String etternavn, String telefon, String epost, String nettside,
                         String virksomhet, String opplysninger) {

        super(fornavn, etternavn, telefon);
        this.epost = new SimpleStringProperty(epost);
        this.nettside = new SimpleStringProperty(nettside);
        this.virksomhet = new SimpleStringProperty(virksomhet);
        this.opplysninger = new SimpleStringProperty(opplysninger);
    }

    public String getEpost() {
        return epost.get();
    }

    public SimpleStringProperty epostProperty() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost.set(epost);
    }

    public String getNettside() {
        return nettside.get();
    }

    public SimpleStringProperty nettsideProperty() {
        return nettside;
    }

    public void setNettside(String nettside) {
        this.nettside.set(nettside);
    }

    public String getVirksomhet() {
        return virksomhet.get();
    }

    public SimpleStringProperty virksomhetProperty() {
        return virksomhet;
    }

    public void setVirksomhet(String virksomhet) {
        this.virksomhet.set(virksomhet);
    }

    public String getOpplysninger() {
        return opplysninger.get();
    }

    public SimpleStringProperty opplysningerProperty() {
        return opplysninger;
    }

    public void setOpplysninger(String opplysninger) {
        this.opplysninger.set(opplysninger);
    }


    public static ObservableList<Kontaktperson> lagKontaktpersonListe(){
        ObservableList<Kontaktperson> kontaktpersonList = FXCollections.observableArrayList();

        kontaktpersonList.add(new Kontaktperson("Magnus", "Hjelmen", "91994468",
                "Magnus@email.com", "example.com", "Google", "I am very cool"));

        kontaktpersonList.add(new Kontaktperson("Tonje", "Pettersen", "12345678",
                "Tonje@email.com", "example.com", "Microsoft", "Jag är från sverige"));


        return kontaktpersonList;
    }

}
