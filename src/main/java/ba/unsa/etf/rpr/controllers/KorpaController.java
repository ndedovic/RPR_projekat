package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ModelManager;
import ba.unsa.etf.rpr.business.NarudzbaManager;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.PekaraException;
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

    NarudzbaManager manager = new NarudzbaManager();
    public static Proizvodi proizvodUKorpi = new Proizvodi();

    @FXML
    void initialize(){
        if(ProdavnicaController.selektovaniProizvod != null){
            nazivLbl.setText(ProdavnicaController.selektovaniProizvod.getNaziv());
            cijenaLbl.setText((ProdavnicaController.selektovaniProizvod.getCijena()));
        }
    }
    public void zabiljeziNarudzbu() throws PekaraException {
        ModelManager model = ModelManager.getInstance();
        Narudzba narudzba = new Narudzba();
        narudzba.setKorisnik(model.getKorisnik().getId());
        narudzba.setCijena(model.getProizvod().getCijena());
        System.out.println(narudzba.getKorisnik());
        manager.dodajNarudbu(narudzba);
    }
    public void potvrdiNarudzbu(ActionEvent actionEvent) {
        try {
            zabiljeziNarudzbu();
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
        try {
            Stage stage1 = (Stage) potvrdiID.getScene().getWindow();
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
