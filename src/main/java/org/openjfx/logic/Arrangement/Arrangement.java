package org.openjfx.logic.Arrangement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Person.Kontaktperson;

import java.io.*;
import java.util.ArrayList;

public class Arrangement implements Serializable {
    private Kontaktperson kontaktperson;
    private SimpleStringProperty type;
    private SimpleStringProperty navn;
    private SimpleStringProperty artist;
    private SimpleStringProperty sted;
    private SimpleStringProperty beskrivelse;       //Tekst beskrivelse av arrangement
    private SimpleIntegerProperty billettPris;      //Billett pris
    private SimpleIntegerProperty billettMaks;      //Maks antall biletter



    public Arrangement(Kontaktperson kontaktperson, String type, String navn, String artist, String sted,
                       String beskrivelse, int billettPris, int billettMaks) {
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

    public void setType(String type) {
        this.type.set(type);
    }

    public String getNavn() {
        return navn.get();
    }

    public void setNavn(String navn) {
        this.navn.set(navn);
    }

    public String getArtist() {
        return artist.get();
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }

    public String getSted() {
        return sted.get();
    }

    public void setSted(String sted) {
        this.sted.set(sted);
    }

    public String getBeskrivelse() {
        return beskrivelse.get();
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse.set(beskrivelse);
    }

    public int getBillettPris() {
        return billettPris.get();
    }

    public void setBillettPris(int billettPris) {
        this.billettPris.set(billettPris);
    }

    public int getBillettMaks() {
        return billettMaks.get();
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





    //Returnerer en ObservableList utifra Lokalet som er valgt, slik at bare Arrangementer med riktig lokale vises
    public ObservableList<Arrangement> filtrertArrangementListe(Lokale lokale){

        return null;
    }



    //Lager et array fra innlest serialisert fil, brukes senere til å populere GUI via lagArrangementListe()
    public ArrayList<Arrangement> lesArrayFraFil() throws IOException, ClassNotFoundException, FileNotFoundException{

        ArrayList<Arrangement> arrangementListe = new ArrayList<>();

        try {

            FileInputStream fis = new FileInputStream("databases/arrangement.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            arrangementListe = (ArrayList<Arrangement>)ois.readObject();

            ois.close();
            fis.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException ois){
            System.err.println("Feil i I/O");
            ois.printStackTrace();
        }catch(ClassNotFoundException c){
            System.err.println("Feil klasse");
            c.printStackTrace();
        }

        return arrangementListe;
    }

    //Henter array fra fil og lar deg legge til et Arrangment til det
    public ArrayList<Arrangement> leggTilArrangementArray(Arrangement arrangement)throws IOException, ClassNotFoundException, FileNotFoundException{
        ArrayList<Arrangement>arrangementListe = lesArrayFraFil();

        arrangementListe.add(arrangement);


        //TODO: Legg til så man skriver til fil igjen.


        return arrangementListe;
    }



    //Lager en ObservableList som JavaFX kan bruke i sine komponenter
    public ObservableList<Arrangement> lagObservableList(ArrayList<Arrangement> arrangementListe) throws Exception{

        ObservableList<Arrangement> arrangementObservableListe = FXCollections.observableArrayList();
        arrangementObservableListe.addAll(arrangementListe);

        return arrangementObservableListe;
    }



    //Legger et spesifikt arrangement til
    public void leggTilArrangement(Arrangement arrangement){


    }


    //Endrer et spesifikt arrangement
    public boolean endreArrangement(Arrangement arrangement){
        return true;
    }

}
