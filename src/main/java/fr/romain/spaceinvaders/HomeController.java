package fr.romain.spaceinvaders;

import fr.romain.spaceinvaders.repository.RecordInformations;
import fr.romain.spaceinvaders.utils.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    public static boolean choice1 = true;
    public static boolean choice2 = false;

    @FXML public Circle choice1Circle, choice2Circle;
    @FXML public TextField tfUsername;
    @FXML public Label lblValidation;

    @FXML
    public void ship1Choice() {
        choice1Circle.setVisible(true);
        choice2Circle.setVisible(false);
        choice1 = true;
        choice2 = false;
    }

    @FXML
    public void ship2Choice() {
        choice1Circle.setVisible(false);
        choice2Circle.setVisible(true);
        choice1 = false;
        choice2 = true;
    }

    // Au click sur le bouton GO, on transfert le username ET le numéro du vaisseau
    @FXML
    public void gameOnAction(ActionEvent actionEvent) throws IOException, SQLException {

        // On vérifie d'abord la validité de l'input
        if (Validation.getHomeNameValidation(tfUsername.getText())) {
            lblValidation.setVisible(false);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("space.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            SpaceController spaceController = loader.getController();
            String result = tfUsername.getText();
            spaceController.transferUsername(result);

            if (choice1 && !choice2) {
                spaceController.transferShipNumber(1);
            } else if (choice2 && !choice1) {
                spaceController.transferShipNumber(2);
            }

            // On enregistre immédiatement le user avec un score à zéro
            RecordInformations.createUser(tfUsername.getText());
        } else {
            lblValidation.setVisible(true);
        }
    }

    @FXML
    void highScoreOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("highscore.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tfUsername.setStyle("-fx-background-radius: 5px; -fx-background-color:  #003500; -fx-text-fill: #009402;");

    }
}
