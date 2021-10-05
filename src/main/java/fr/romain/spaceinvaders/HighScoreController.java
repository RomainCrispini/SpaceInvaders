package fr.romain.spaceinvaders;

import fr.romain.spaceinvaders.entities.User;
import fr.romain.spaceinvaders.repository.RecordInformations;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HighScoreController implements Initializable {

    @FXML private TableView<User> tvHighScore;
    @FXML private TableColumn<User, String> colUsername;
    @FXML private TableColumn<User, Integer> colHighScore;

    @FXML
    public void returnOnHomeAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void displayTableView() {
        ObservableList<User> usersList = RecordInformations.getUsersList();
        // On fait correspondre chacune des propriétés de l'objet book avec chacune des colonnes du TableView
        colUsername.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        colHighScore.setCellValueFactory(new PropertyValueFactory<User, Integer>("highScore"));
        tvHighScore.setItems(usersList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // On appelle la méthode qui permet de récupérer les scores de la BDD et remplir la TableView
        displayTableView();
    }
}
