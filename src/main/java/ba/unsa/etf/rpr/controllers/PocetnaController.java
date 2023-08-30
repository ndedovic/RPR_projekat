package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.AppFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * kontroler za pocetnu
 */
public class PocetnaController {
    public Button aboutBtn;
    public Button helpBtn;
    public Button loginBtn;
    public Button registrationBtn;

    /**
     * Metoda za prikaz stranice o nama
     * @param actionEvent
     */
    public void prikazOnama(ActionEvent actionEvent) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/onama.fxml"));
            Stage stage = new Stage();
            stage.setTitle("O nama");
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * metoda za prikaz stranice za pomoc
     * @param actionEvent
     */
    public void prikazPomoci(ActionEvent actionEvent) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/pomoc.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Pomoc");
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metoda za otvaranje login stranice
     * @param actionEvent
     */
    public void prikazLogina(ActionEvent actionEvent) {
        try {
            Stage stage1 = (Stage)loginBtn.getScene().getWindow();
            stage1.close();
            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Prijava");
            Image icon = new Image(getClass().getResourceAsStream("/images/ikonica.jpg"));
            stage.getIcons().add(icon);
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metoda za otvaranje stranice za registraciju
     * @param actionEvent
     */
    public void prikazRegistracije(ActionEvent actionEvent) {
        try {
            Stage stage1 = (Stage)registrationBtn.getScene().getWindow();
            stage1.close();
            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/registracija.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Registracija");
            Image icon = new Image(getClass().getResourceAsStream("/images/ikonica.jpg"));
            stage.getIcons().add(icon);
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
