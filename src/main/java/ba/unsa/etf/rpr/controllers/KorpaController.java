package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class KorpaController {
    public Label nazivLbl;
    public Label cijenaLbl;
    public Button potvrdiID;
    public Button otkaziID;

    @FXML
    void initialize(){
        if(ProdavnicaController.selektovaniProizvod != null){
            nazivLbl.setText(ProdavnicaController.selektovaniProizvod.getNaziv());
            cijenaLbl.setText((ProdavnicaController.selektovaniProizvod.getCijena()));
        }
    }

    public void potvrdiNarudzbu(ActionEvent actionEvent) {
        try {
            Stage stage1 = (Stage) potvrdiID.getScene().getWindow();
            stage1.close();
            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/potvrdaNarudzbe.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Potvrda");
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }

    public void otkaziNarudzbu(ActionEvent actionEvent) {
    }
}
