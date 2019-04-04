package org.openjfx.logic.Person;

import javafx.beans.property.SimpleStringProperty;

public abstract class Person {
    private SimpleStringProperty fornavn;
    private SimpleStringProperty etternavn;
    private SimpleStringProperty telefon;

    public Person(String fornavn, String etternavn, String telefon) {
        this.fornavn = new SimpleStringProperty(fornavn);
        this.etternavn = new SimpleStringProperty(etternavn);
        this.telefon = new SimpleStringProperty(telefon);
    }

    public String getFornavn() {
        return fornavn.get();
    }

    public SimpleStringProperty fornavnProperty() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn.set(fornavn);
    }

    public String getEtternavn() {
        return etternavn.get();
    }

    public SimpleStringProperty etternavnProperty() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn.set(etternavn);
    }

    public String getTelefon() {
        return telefon.get();
    }

    public SimpleStringProperty telefonProperty() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon.set(telefon);
    }
}
