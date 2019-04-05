package org.openjfx.logic.Person;


import java.io.Serializable;

public abstract class Person implements Serializable {
    private String fornavn;
    private String etternavn;
    private String telefon;


    public Person(String fornavn, String etternavn, String telefon) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefon = telefon;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
