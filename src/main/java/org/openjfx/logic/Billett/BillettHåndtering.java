package org.openjfx.logic.Billett;

import org.openjfx.logic.Arrangement.Arrangement;

public class BillettHåndtering {

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
