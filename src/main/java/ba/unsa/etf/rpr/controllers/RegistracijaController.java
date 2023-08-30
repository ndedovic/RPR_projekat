package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.AppFX;
import ba.unsa.etf.rpr.business.KorisnikManager;
import ba.unsa.etf.rpr.business.NarudzbaManager;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.PekaraException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class RegistracijaController {
    @FXML public TextField imeFld;
    @FXML public TextField prezimeFld;
    @FXML public TextField emailFld;
    @FXML public TextField passwordFld;
    @FXML public Label imeCheck;
    @FXML public Label prezimeCheck;
    @FXML public Label emailCheck;
    @FXML
    public Label passwordCheck;
    KorisnikManager korisnikManager = new KorisnikManager();
    public Button registracijaBtn;

    @FXML
    void initialize(){
        imeFld.getStyleClass().add("poljeJeIspravno");
        prezimeFld.getStyleClass().add("poljeJeIspravno");
        passwordFld.getStyleClass().add("poljeJeIspravno");
        emailFld.getStyleClass().add("poljeJeIspravno");
        imeFld.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.toString() == null || n.toString().length() <= 2 || !n.toString().matches("^[a-zA-Z]+$")) {
                    imeFld.getStyleClass().removeAll("poljeJeIspravno");
                    imeFld.getStyleClass().add("poljeNijeIspravno");
                } else {
                    imeFld.getStyleClass().removeAll("poljeNijeIspravno");
                    imeFld.getStyleClass().add("poljeJeIspravno");
                }
            }
        });
        prezimeFld.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.toString() == null || n.toString().length() <= 2 || !n.toString().matches("^[a-zA-Z]+$")) {
                    prezimeFld.getStyleClass().removeAll("poljeJeIspravno");
                    prezimeFld.getStyleClass().add("poljeNijeIspravno");
                } else {
                    prezimeFld.getStyleClass().removeAll("poljeNijeIspravno");
                    prezimeFld.getStyleClass().add("poljeJeIspravno");
                }
            }
        });
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


    public void akcijaRegistrovanja(ActionEvent actionEvent) throws PekaraException {

        String ime = imeFld.getText();
        String prezime = prezimeFld.getText();
        String sifra = passwordFld.getText();
        String email = emailFld.getText();
        int pomocna = 0;
        if(Objects.equals(ime, ""))
            pomocna++;
        if(Objects.equals(prezime, ""))
            pomocna++;
        if(Objects.equals(email, ""))
            pomocna++;
        if(Objects.equals(sifra, "") || sifra.length() < 8)
            pomocna++;
        if (pomocna == 0) {
            Korisnik korisnik = new Korisnik();
            korisnik.setIme(ime);
            korisnik.setPrezime(prezime);
            korisnik.setPassword(sifra);
            korisnik.setEmail(email);


            try {
                FileReader r = new FileReader("src/main/resources/application.properties");
                Properties p = new Properties();
                p.load(r);
                String string1 = p.getProperty("db.connection_string");
                String string2 = p.getProperty("db.username");
                String string3 = p.getProperty("db.password");

                Connection connection = DriverManager.getConnection(string1, string2, string3);
                System.out.println(string1 + " " + string2 + " " + string3);

                korisnikManager.dodajKorisnika(korisnik);
                try {
                    Stage stage1 = (Stage) registracijaBtn.getScene().getWindow();
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
                connection.close();

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void zatvoriRegistraciju(ActionEvent actionEvent) {
        try {
            Stage stage1 = (Stage) registracijaBtn.getScene().getWindow();
            stage1.close();
            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/pocetna.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Pocetna");
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }
}
