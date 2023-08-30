package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * kontroler za onama
 */
public class OnamaController {
    public Button zatvoriBtn;

    /**
     * Zatvaranje stranice o nama
     * @param actionEvent
     */
    public void zatvaranjeOnama(ActionEvent actionEvent) {
        Stage stage =(Stage)zatvoriBtn.getScene().getWindow();
        stage.close();
    }
}
