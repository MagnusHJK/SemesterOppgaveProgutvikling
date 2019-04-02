package org.openjfx.logic.Lokale;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class LokaleCellFactory implements Callback<ListView<Lokale>, ListCell<Lokale>> {

    @Override
    public ListCell<Lokale> call(ListView<Lokale> listView){
        return new LokaleCell();
    }
}
