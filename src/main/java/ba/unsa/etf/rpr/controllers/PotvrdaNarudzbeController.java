package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class PotvrdaNarudzbeController {
    public Button zatvoriBtn;

    public void zatvoriProzor(ActionEvent actionEvent) {
        try {
            Stage stage1 = (Stage) zatvoriBtn.getScene().getWindow();
            stage1.close();
            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/prodavnica.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Prodavnica");
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }
}
