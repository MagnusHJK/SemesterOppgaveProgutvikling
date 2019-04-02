package org.openjfx.logic.Arrangement;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class ArrangementCellFactory implements Callback<ListView<Arrangement>, ListCell<Arrangement>> {

    @Override
    public ListCell<Arrangement> call(ListView<Arrangement> tabellView){
        return new ArrangementCell();
    }
}
