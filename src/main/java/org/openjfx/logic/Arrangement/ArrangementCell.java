package org.openjfx.logic.Arrangement;

import javafx.scene.control.ListCell;
import javafx.scene.control.TableView;

public class ArrangementCell extends ListCell<Arrangement> {

    @Override
    protected void updateItem(Arrangement arrangement, boolean tom){
        super.updateItem(arrangement, tom);

        if(tom || arrangement == null || arrangement.getNavn() == null){
            setText(null);
        } else {
            setText(arrangement.getNavn());
        }
    }
}
