package org.openjfx.logic.Arrangement;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Billett.Billett;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.inputException;
import org.openjfx.logic.exceptions.klasseException;
import org.openjfx.logic.Lokale.LokaleHåndtering;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonHåndtering;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//Klasse for håndtering av Arrangement fra GUI, lages, endres eller slettes
public class ArrangementHåndtering {


    //Lager en ObservableList som JavaFX kan bruke i sine komponenter
    public ObservableList<Arrangement> lagObservableList(ArrayList<Arrangement> ArrayListe) throws Exception{

        ObservableList<Arrangement> observListe = FXCollections.observableArrayList();
        observListe.addAll(ArrayListe);

        return observListe;
    }


    //Lager ArrayList
    public List<Arrangement> lagArrayList(ObservableList<Arrangement> observListe){
        List<Arrangement> ArrangementList = observListe.stream().collect(Collectors.toList());

        return ArrangementList;
    }


    //Ser gjennom Arrangement listen om noen av de hører til Lokalet basert på typen deres
    //returnerer en ObservableList som JavaFX kan bruke
    public ObservableList<Arrangement> filtrerArrangementer(ArrayList<Arrangement> liste, Lokale lokale){
       ObservableList<Arrangement> observListe = FXCollections.observableArrayList();
       observListe.addAll(liste);

        ObservableList<Arrangement> filtrertListe = observListe
                .stream()
                .filter(Arrangement -> Arrangement.getTypeString().equals(lokale.getType()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        return filtrertListe;
    }

    //Finner all info om det arrangementet du trykker på
    public String filtrerArrangementDetaljer(ArrayList<Arrangement> liste, Arrangement arrangement){
        for(Arrangement index : liste){
            if(index.getArrangementID().equals(arrangement.getArrangementID())){
                return "Tittel: " + arrangement.getNavn() + "\n" +
                       "Artist: " + arrangement.getArtist() + "\n" +
                       "Sted: " + arrangement.getSted() + " " + arrangement.getType() +"\n" +
                       "Dato/Tid: " + arrangement.getDato() + " - " + arrangement.getTidspunkt() + "\n" +
                       "Pris: " + arrangement.getBillettPris() + "\n" +
                       "Maks Billetter: " + arrangement.getBillettMaks() + "\n" +
                       "Beskrivelse: " + arrangement.getBeskrivelse() + "\n";
            }
        }
        return "";
    }

    public void oppdaterArrangementSalg(Arrangement arrangement){
        ArrangementSerialiser serialiser = new ArrangementSerialiser();

        try{
            ArrayList<Arrangement> liste = serialiser.lesArrayFraFil();

            //Fjerner det gamle arrangementet og legger til det nye, med riktige plasser
            liste.removeIf(Arrangement -> Arrangement.getArrangementID().equals(arrangement.getArrangementID()));
            liste.add(arrangement);

            serialiser.skrivArrayTilFil(liste);

        }catch(IOException e){
            alertbox.feil(inputException.ioException());
        } catch(ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }
    }

    public void slettArrangement(Arrangement arrangement){
        ArrangementSerialiser serialiser = new ArrangementSerialiser();

        try{
            ArrayList<Arrangement> liste = serialiser.lesArrayFraFil();

            liste.removeIf(Arrangement -> Arrangement.getArrangementID().equals(arrangement.getArrangementID()));

            serialiser.skrivArrayTilFil(liste);
        }catch(IOException e){
           alertbox.feil(inputException.ioException());
        } catch(ClassNotFoundException  cnf) {
            alertbox.feil(klasseException.klasseException());
        }

    }

    public void endreArrangement(Arrangement arrangement) {
        ArrangementSerialiser serialiser = new ArrangementSerialiser();

        try {
            ArrayList<Arrangement> liste = serialiser.lesArrayFraFil();

            liste.removeIf(Arrangement -> Arrangement.getArrangementID().equals(arrangement.getArrangementID()));
            liste.add(arrangement);

            serialiser.skrivArrayTilFil(liste);

        } catch (IOException e) {
            alertbox.feil(inputException.ioException());
        } catch (ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }
    }

    //Lager midlertidig statisk Arrangement liste, husk å konverter til ObservableList før du bruker i JavaFX

    public ArrayList<Arrangement> lagArrangementListe(){
        ArrayList<Arrangement>arrangementListe = new ArrayList<>();

        PersonHåndtering person = new PersonHåndtering();
        ArrayList<Kontaktperson> kontaktpersonListe = person.lagKontaktpersonListe();

        LokaleHåndtering lokale = new LokaleHåndtering();
        ArrayList<Lokale> lokaleListe = lokale.lagLokaleListe();

        LocalDate dato1 = LocalDate.of(2019,4,20);

        Billett[] salg = new Billett[69];
        Billett[] salg2 = new Billett[100];


        arrangementListe.add(new Arrangement("023", kontaktpersonListe.get(0), lokaleListe.get(0),
                "La La Land", "Emma Stone", "Ottestad", dato1, "19:00", "Sykt bra film.", 100, 69, salg));

        arrangementListe.add(new Arrangement("047", kontaktpersonListe.get(1), lokaleListe.get(1),
                "Cats", "Gunnar", "Ottestad", dato1,"20:00", "Sykt kule katter", 250, 100, salg2));


        return arrangementListe;
    }
}
