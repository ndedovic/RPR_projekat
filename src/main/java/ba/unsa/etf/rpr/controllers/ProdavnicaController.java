package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ProizvodiManager;
import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.PekaraException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.Date;
import java.util.List;

public class ProdavnicaController {
    public Button btnKorpa;
    public Button btnSlatko;
    public Button btnSlano;
    public Button btnDodajUKorpu;
    public TableView<Proizvodi> tableViewID;
    public TableColumn<Proizvodi, String> tableViewNaziv;
    public TableColumn<Proizvodi, String> tableViewCijena;

    ProizvodiManager manager = new ProizvodiManager();
    @FXML
    void initialize() throws PekaraException {
        tableViewNaziv.setCellValueFactory(new PropertyValueFactory<Proizvodi, String>("naziv"));
        tableViewCijena.setCellValueFactory(new PropertyValueFactory<Proizvodi, String>("cijena"));

    }
    public void prikaziKorpu(ActionEvent actionEvent) {
    }

    public void prikaziSlatkeProizvode(ActionEvent actionEvent) throws PekaraException {

        tableViewID.setItems(FXCollections.observableList(manager.pronadjiProizvodPoKategoriji(1)));
        tableViewID.refresh();
    }

    public void prikaziSlaneProizvode(ActionEvent actionEvent) throws PekaraException {
        tableViewID.setItems(FXCollections.observableList(manager.pronadjiProizvodPoKategoriji(2)));
        tableViewID.refresh();
    }

    public void dodajUProizvodUKorpu(ActionEvent actionEvent) {
    }
}
