package org.openjfx.logic.Billett;

import org.openjfx.logic.Arrangement.Arrangement;

import java.io.Serializable;
import java.time.LocalDate;

public class Billett implements Serializable {
    private Arrangement arrangement;
    private int plassnummer;
    private String lokale;
    private LocalDate dato;
    private String tidspunkt;
    private String telefonnr;

    public Billett(Arrangement arrangement, int plassnummer, String lokale, LocalDate dato, String tidspunkt, String telefonnr) {
        this.arrangement = arrangement;
        this.plassnummer = plassnummer;
        this.lokale = lokale;
        this.dato = dato;
        this.tidspunkt = tidspunkt;
        this.telefonnr = telefonnr;
    }

    public Arrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(Arrangement arrangement) {
        this.arrangement = arrangement;
    }

    public int getPlassnummer() {
        return plassnummer;
    }

    public void setPlassnummer(int plassnummer) {
        this.plassnummer = plassnummer;
    }

    public String getLokale() {
        return lokale;
    }

    public void setLokale(String lokale) {
        this.lokale = lokale;
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

    public String getTelefonnr() {
        return telefonnr;
    }

    public void setTelefonnr(String telefonnr) {
        this.telefonnr = telefonnr;
    }

    @Override
    public String toString(){
        return "Plass: " + this.getPlassnummer() + " [" + this.getDato() + " - " + this.getTidspunkt() + "]";
    }
}
