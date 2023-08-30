package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * kontroler za pomoc
 */
public class PomocController {
    public Button zatvoriBtn;

    /**
     * Metoda za zatvaranje prozora za pomoc
     * @param actionEvent
     */
    public void zatvaranjeOnama(ActionEvent actionEvent) {
        Stage stage =(Stage)zatvoriBtn.getScene().getWindow();
        stage.close();
    }
}
