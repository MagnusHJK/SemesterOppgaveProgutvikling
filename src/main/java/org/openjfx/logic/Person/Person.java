package org.openjfx.logic.Person;

public class Person {
    private String fornavnavn;
    private String etternavn;
    private String telefon;

    public Person(String fornavnavn, String etternavn, String telefon) {
        this.fornavnavn = fornavnavn;
        this.etternavn = etternavn;
        this.telefon = telefon;
    }

    public String getFornavnavn() {
        return fornavnavn;
    }

    public void setFornavnavn(String fornavnavn) {
        this.fornavnavn = fornavnavn;
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
