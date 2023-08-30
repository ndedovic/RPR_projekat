package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    }

    public void otkaziNarudzbu(ActionEvent actionEvent) {
    }
}
