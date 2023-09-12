package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.KorisnikManager;
import ba.unsa.etf.rpr.business.ModelManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.PekaraException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;


public class LoginController {

    public Button loginBtn;
    public TextField emailFld;
    public PasswordField passwordFld;
    KorisnikManager korisnikManager = new KorisnikManager();
    @FXML
    void initialize(){
        passwordFld.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if ( n.length() < 8) {
                    passwordFld.getStyleClass().removeAll("poljeJeIspravno");
                    passwordFld.getStyleClass().add("poljeNijeIspravno");
                } else {
                    passwordFld.getStyleClass().removeAll("poljeNijeIspravno");
                    passwordFld.getStyleClass().add("poljeJeIspravno");
                }
            }
        });
        emailFld.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if ( n.length() < 8  || !n.toString().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                    emailFld.getStyleClass().removeAll("poljeJeIspravno");
                    emailFld.getStyleClass().add("poljeNijeIspravno");
                } else {
                    emailFld.getStyleClass().removeAll("poljeNijeIspravno");
                    emailFld.getStyleClass().add("poljeJeIspravno");
                }
            }
        });

    }

    /**
     * Metoda koja se izvršava kada se pritisne dugme login
     * @param actionEvent
     * @throws PekaraException
     */
    public void otvaranjeHomePage(ActionEvent actionEvent) throws PekaraException {
        String email = emailFld.getText();
        String sifra = passwordFld.getText();
        ModelManager model = ModelManager.getInstance();
        List<Korisnik> korisnici = korisnikManager.dajSveKorisnike();

        if(!(Objects.equals(email, "") || Objects.equals(sifra,""))) {
            for(Korisnik k : korisnici){
                if(k.getEmail().equals(email) && k.getPassword().equals(sifra)){
                    try {
                        model.setKorisnik(k);
                        Stage stage1 = (Stage) loginBtn.getScene().getWindow();
                        stage1.close();
                        Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/mojeNarudzbe.fxml"));
                        Stage stage = new Stage();
                        stage.setTitle("Moje narudzbe");
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
        }

    }

    /**
     * Metoda koja se izvršava kada se pritisne dugme zatvori
     * @param actionEvent
     */
    public void zatvoriLogin(ActionEvent actionEvent) {
        try {
            Stage stage1 = (Stage) loginBtn.getScene().getWindow();
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
