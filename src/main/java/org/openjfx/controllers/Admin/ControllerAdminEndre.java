package org.openjfx.controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.openjfx.logic.Arrangement.Arrangement;
import org.openjfx.logic.Arrangement.ArrangementHåndtering;
import org.openjfx.logic.Arrangement.ArrangementSerialiser;
import org.openjfx.logic.Lokale.LokaleSerialiser;
import org.openjfx.logic.Person.Kontaktperson;
import org.openjfx.logic.Person.PersonHåndtering;
import org.openjfx.logic.Person.PersonSerialiser;
import org.openjfx.logic.exceptions.alertbox;
import org.openjfx.logic.Lokale.Lokale;
import org.openjfx.logic.Lokale.LokaleCellFactory;
import org.openjfx.logic.Lokale.LokaleHåndtering;
import org.openjfx.logic.exceptions.valgException;
import org.openjfx.logic.exceptions.nullException;
import org.openjfx.logic.exceptions.arrangementException;

public class ControllerAdminEndre{

    public void initialize() throws Exception{

        LokaleHåndtering lokaler = new LokaleHåndtering();
        LokaleSerialiser serialiser = new LokaleSerialiser();

        EndreTabell.setCellFactory(new LokaleCellFactory());
        EndreTabell.setItems(lokaler.lagObservableList(serialiser.lesArrayFraFil()));

    }

    @FXML
    private ListView<Lokale> EndreTabell;

}
