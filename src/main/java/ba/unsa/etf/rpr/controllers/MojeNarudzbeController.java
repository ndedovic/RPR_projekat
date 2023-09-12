package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ModelManager;
import ba.unsa.etf.rpr.business.NarudzbaManager;
import ba.unsa.etf.rpr.domain.Narudzba;
import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.PekaraException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class MojeNarudzbeController {
    public TableView tableID;
    public TableColumn proizvodID;
    public TableColumn cijenaID;
    public Button shopID;
    NarudzbaManager nm = new NarudzbaManager();

    @FXML
    public void initialize() throws PekaraException {
        proizvodID.setCellValueFactory(new PropertyValueFactory<Proizvodi, String>("naziv"));
        cijenaID.setCellValueFactory(new PropertyValueFactory<Proizvodi, String>("cijena"));
        ModelManager manager = ModelManager.getInstance();
        tableID.setItems(FXCollections.observableList(nm.pronadjiNarudzbuPoKorisniku(manager.getKorisnik().getId())));
        tableID.refresh();
    }
    public void prikaziShop(ActionEvent actionEvent) {
        try {
            Stage stage1 = (Stage) shopID.getScene().getWindow();
            stage1.close();
            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/prodavnica.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Prodavnica");
            Image icon = new Image(getClass().getResourceAsStream("/images/ikonica.jpg"));
            stage.getIcons().add(icon);
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }
}
