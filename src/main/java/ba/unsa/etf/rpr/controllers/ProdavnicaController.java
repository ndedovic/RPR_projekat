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
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Date;
import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * Kontroler za prodavnicu
 */
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

    /**
     * Motoda za prikaz sadžaja korpe, izcršava se kada se pritisne dugme Korpa
     * @param actionEvent
     */
    public void prikaziKorpu(ActionEvent actionEvent) {
        try {
            Stage stage1 = (Stage) btnKorpa.getScene().getWindow();
            stage1.close();
            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/korpa.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Korpa");
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

    /**
     * Metoda za prikaz proizvoda koji pripadaju kategoriji 1
     * @param actionEvent
     * @throws PekaraException
     */
    public void prikaziSlatkeProizvode(ActionEvent actionEvent) throws PekaraException {

        tableViewID.setItems(FXCollections.observableList(manager.pronadjiProizvodPoKategoriji(1)));
        tableViewID.refresh();
    }

    /**
     * Metoda za prikaz proizvoda koji pripadaju kategoriji 2
     * @param actionEvent
     * @throws PekaraException
     */
    public void prikaziSlaneProizvode(ActionEvent actionEvent) throws PekaraException {
        tableViewID.setItems(FXCollections.observableList(manager.pronadjiProizvodPoKategoriji(2)));
        tableViewID.refresh();
    }

    /**
     * Metoda za dodavanje proizvoda u korpu
     * @param actionEvent
     */
    public void dodajProizvodUKorpu(ActionEvent actionEvent) {
        Proizvodi p = tableViewID.getSelectionModel().getSelectedItem();
        ModelManager model = ModelManager.getInstance();
        if(p != null){
            selektovaniProizvod = p;
            tableViewID.getSelectionModel().clearSelection();
            model.setProizvod(selektovaniProizvod);
            label.setText("");
        }else{
            label.setText("Nijedan proizvod nije selektovan");
        }
    }

    /**
     * Metoda za zatvaranje prodavnice, izvrsava se kada se pritisne dugme Zatvori
     * @param actionEvent
     */
    public void zatvoriProdavnicu(ActionEvent actionEvent) {
        try {
            Stage stage1 = (Stage) btnKorpa.getScene().getWindow();
            stage1.close();
            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/pocetna.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Pocetna");
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
