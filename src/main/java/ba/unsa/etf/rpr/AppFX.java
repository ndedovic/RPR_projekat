package ba.unsa.etf.rpr;


import ba.unsa.etf.rpr.business.KorisnikManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * Main class for working with JavaFX framework
 */

public class AppFX extends Application {
    private static Stage primaryStage;
    public static Stage getPrimaryStage() {
        return primaryStage;

    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/pocetna.fxml"));
        stage.setTitle("Pekara Zlatni dukat");
        Image icon = new Image(getClass().getResourceAsStream("/images/ikonica.jpg"));
        stage.getIcons().add(icon);
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }
}
