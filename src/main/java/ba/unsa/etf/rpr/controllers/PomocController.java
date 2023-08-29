package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PomocController {
    public Button zatvoriBtn;

    public void zatvaranjeOnama(ActionEvent actionEvent) {
        Stage stage =(Stage)zatvoriBtn.getScene().getWindow();
        stage.close();
    }
}
