package org.openjfx.logic.Billett;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.logic.Arrangement.Arrangement;

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
}
