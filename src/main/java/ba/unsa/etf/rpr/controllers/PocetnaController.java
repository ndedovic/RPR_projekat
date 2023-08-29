package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.AppFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class PocetnaController {
    public Button aboutBtn;
    public Button helpBtn;
    public Button loginBtn;
    public Button registrationBtn;

    public void prikazOnama(ActionEvent actionEvent) {
    }

    public void prikazPomoci(ActionEvent actionEvent) {
    }

    public void prikazLogina(ActionEvent actionEvent) {
        try {
            Stage stage1 = (Stage)loginBtn.getScene().getWindow();
            stage1.close();
            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Prijava");
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
