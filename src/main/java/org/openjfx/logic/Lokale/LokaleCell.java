package org.openjfx.logic.Lokale;

import javafx.scene.control.ListCell;


//Klasse for å fylle yt ListViews med Lokale objekter, men bare typen deres feks Kino, Konsert, etc
public class LokaleCell extends ListCell<Lokale> {

    @Override
    protected void updateItem(Lokale lokale, boolean tom){
        super.updateItem(lokale, tom);

        if(tom || lokale == null || lokale.getType() == null){
            setText(null);
        } else {
            setText(lokale.getType());
        }
    }
}
