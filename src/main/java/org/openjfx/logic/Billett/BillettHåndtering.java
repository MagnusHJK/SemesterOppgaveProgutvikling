package org.openjfx.logic.Billett;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementHåndtering;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.exceptions.inputException;
import org.openjfx.logic.exceptions.klasseException;

import java.io.IOException;
import java.util.ArrayList;


public class BillettHåndtering {


    //Lager en ObservableList som JavaFX kan bruke i sine komponenter
    public ObservableList<Billett> lagObservableList(ArrayList<Billett> ArrayListe) throws Exception{

        ObservableList<Billett> observListe = FXCollections.observableArrayList();
        observListe.addAll(ArrayListe);

        return observListe;
    }


    //Finner en ledig plass til personen
    public int finnPlassnummer(Arrangement arrangement){
        int solgtePlasser = 0;
        int plassNummer = 0;

        for(int i = 0; i < arrangement.getSalg().length; i++){
            if(arrangement.getSalg()[i] != null){
                solgtePlasser++;
            }
        }

        //Sjekker om det er fult
        if(solgtePlasser < arrangement.getBillettMaks()){
            plassNummer = solgtePlasser + 1;
        }

        return plassNummer;
    }


    public String leggTilBillett(Arrangement arrangement, String telefonnr, int antallBilletter){
        BillettHåndtering håndteringBill = new BillettHåndtering();
        ArrangementHåndtering håndteringArr = new ArrangementHåndtering();

        int plassnummer = 0;
        String billettTekst = "";
        ArrayList<Billett> billettListe;


        for(int i = 0; i < antallBilletter; i++){
            plassnummer = håndteringBill.finnPlassnummer(arrangement);


            Billett billett = new Billett(arrangement, plassnummer, arrangement.getSted(),
                    arrangement.getDato(), arrangement.getTidspunkt(), telefonnr);

            arrangement.getSalg()[plassnummer] = billett;


            billettTekst += arrangement.getSalg()[plassnummer].toString() + "\n";

            //Serialiserer og legger til billettene i database
            try{
                BillettSerialiser serialiserBill = new BillettSerialiser();
                billettListe = serialiserBill.lesArrayFraFil();


                billettListe.add(billett);
                serialiserBill.skrivArrayTilFil(billettListe);

                håndteringArr.oppdaterArrangementSalg(arrangement);

            }catch(IOException e){
                alertbox.feil(inputException.ioException());
            }catch (ClassNotFoundException e){
                alertbox.feil(klasseException.klasseException());
            }
        }


        return billettTekst;
    }

    public void slettBillett(Billett billett){
        BillettSerialiser serialiser = new BillettSerialiser();

        try{
            ArrayList<Billett> liste = serialiser.lesArrayFraFil();

            liste.removeIf(Billett -> Billett.getPlassnummer()  == (billett.getPlassnummer()));

            billett.getArrangement().getSalg()[billett.getPlassnummer()] = null;

            serialiser.skrivArrayTilFil(liste);
        }catch(IOException e){
           alertbox.feil(inputException.ioException());
        } catch(ClassNotFoundException cnf) {
            alertbox.feil(klasseException.klasseException());
        }

    }
}
