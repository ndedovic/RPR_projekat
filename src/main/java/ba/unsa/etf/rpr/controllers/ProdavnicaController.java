package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ModelManager;
import ba.unsa.etf.rpr.business.ProizvodiManager;
import ba.unsa.etf.rpr.domain.Proizvodi;
import ba.unsa.etf.rpr.exceptions.PekaraException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Date;
import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ProdavnicaController {
    public Button btnKorpa;
    public Button btnSlatko;
    public Button btnSlano;
    public Button btnDodajUKorpu;
    public TableView<Proizvodi> tableViewID;
    public TableColumn<Proizvodi, String> tableViewNaziv;
    public TableColumn<Proizvodi, String> tableViewCijena;
    public static Proizvodi selektovaniProizvod = new Proizvodi();
    public Label label;
    ProizvodiManager manager = new ProizvodiManager();
    @FXML
    void initialize() throws PekaraException {
        tableViewNaziv.setCellValueFactory(new PropertyValueFactory<Proizvodi, String>("naziv"));
        tableViewCijena.setCellValueFactory(new PropertyValueFactory<Proizvodi, String>("cijena"));

    }
    public void prikaziKorpu(ActionEvent actionEvent) {
        try {
            Stage stage1 = (Stage) btnKorpa.getScene().getWindow();
            stage1.close();
            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/korpa.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Korpa");
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }

    public void prikaziSlatkeProizvode(ActionEvent actionEvent) throws PekaraException {

        tableViewID.setItems(FXCollections.observableList(manager.pronadjiProizvodPoKategoriji(1)));
        tableViewID.refresh();
    }

    public void prikaziSlaneProizvode(ActionEvent actionEvent) throws PekaraException {
        tableViewID.setItems(FXCollections.observableList(manager.pronadjiProizvodPoKategoriji(2)));
        tableViewID.refresh();
    }

    public void dodajProizvodUKorpu(ActionEvent actionEvent) {
        Proizvodi p = tableViewID.getSelectionModel().getSelectedItem();
        ModelManager model = new ModelManager();
        if(p != null){
            selektovaniProizvod = p;
            tableViewID.getSelectionModel().clearSelection();
            model.setProizvod(selektovaniProizvod);
            label.setText("");
        }else{
            label.setText("Nijedan proizvod nije selektovan");
        }
    }
}
