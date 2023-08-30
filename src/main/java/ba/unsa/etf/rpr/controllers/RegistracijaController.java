package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.KorisnikManager;
import ba.unsa.etf.rpr.business.NarudzbaManager;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.PekaraException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class RegistracijaController {
    @FXML public TextField imeFld;
    @FXML public TextField prezimeFld;
    @FXML public TextField emaildFld;
    @FXML public TextField passwordFld;
    @FXML public Label imeCheck;
    @FXML public Label prezimeCheck;
    @FXML public Label emailCheck;
    @FXML
    public Label passwordCheck;
    KorisnikManager korisnikManager = new KorisnikManager();
    public Button registracijaBtn;

    public void akcijaRegistrovanja(ActionEvent actionEvent) throws PekaraException {
        List<Korisnik> korisnici = korisnikManager.dajSveKorisnike();
        String ime = imeFld.getText();
        String prezime = prezimeFld.getText();
        String email = emaildFld.getText();
        String password = passwordFld.getText();

        int pomocna = 0;

        if (Objects.equals(ime, "")) {
            imeCheck.setText("Ime ne može biti prazno");
            pomocna++;
        } else {
            imeCheck.setText("");
        }

        if (Objects.equals(prezime, "")) {
            prezimeCheck.setText("Prezime ne može biti prazno");
            pomocna++;
        } else {
            prezimeCheck.setText("");
        }

        if (Objects.equals(email, "")) {
            emailCheck.setText("Email ne može biti prazan");
            pomocna++;
        } else {
            emailCheck.setText("");
        }

        if (Objects.equals(password, "")) {
            passwordCheck.setText("Password ne može biti prazan");
            pomocna++;
        } else {
            passwordCheck.setText("");
        }

        if(pomocna == 0){
            Korisnik korisnik = new Korisnik();
            korisnik.setPassword(password);
            korisnik.setPrezime(prezime);
            korisnik.setEmail(email);
            korisnik.setIme(ime);

            try {
                /*FileReader r = new FileReader("src/main/resources/application.properties");
                Properties p = new Properties();
                p.load(r);
                String string1 = p.getProperty("db.server");
                String string2 = p.getProperty("db.username");
                String string3 = p.getProperty("db.password");

                Connection connection = DriverManager.getConnection(string1, string2, string3);
                System.out.println(string1 + " " + string2 + " " + string3);*/

                //korisnikManager.dodajKorisnika(korisnik);

                try {
                    Stage stage = (Stage) registracijaBtn.getScene().getWindow();
                    stage.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/pocetna.fxml"));
                    fxmlLoader.setController(new PocetnaController());
                    Parent root = fxmlLoader.load();
                    stage.setScene(new Scene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
                    stage.setResizable(false);
                    stage.show();

                } catch (Exception e1) {
                    System.out.println(e1.getMessage());
                }
                //connection.close();

            }catch (Exception e2) {
                e2.printStackTrace();
            }

        }

    }
}
