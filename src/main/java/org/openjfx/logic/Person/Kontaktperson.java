package org.openjfx.logic.Person;

public class Kontaktperson extends Person {
    private String epost;
    private String nettside;
    private String virksomhet;
    private String opplysninger;

    public Kontaktperson(String fornavnavn, String etternavn, String telefon) {
        super(fornavnavn, etternavn, telefon);
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
}
