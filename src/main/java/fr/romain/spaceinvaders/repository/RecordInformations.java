package fr.romain.spaceinvaders.repository;

import fr.romain.spaceinvaders.entities.User;
import fr.romain.spaceinvaders.utils.DataBaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecordInformations {

    // Méthode qui permet de factoriser la connection à la BDD, en même temps que d'exécuter nos requêtes
    private static void executeQuery(String query) throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur SQL");
        }
        connection.close();
    }

    public static ObservableList<User> getUsersList() {
        ObservableList<User> usersList = FXCollections.observableArrayList();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();
        String query = "SELECT * FROM user ORDER BY user_score DESC LIMIT 10";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                User user = new User(rs.getString("user_name"), rs.getInt("user_score"));
                usersList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur dans le SELECT *");
        }
        return usersList;
    }

    public static void createUser(String username) {

        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();
        String query1 = "SELECT * FROM user WHERE user_name = '" + username + "'";
        try {
            // On vérifie dans un premier temps s'il existe déjà le même username
            int count = 0;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query1);
            while (rs.next()) {
                count++;
            }
            if (count == 0) {
                User user = new User();
                user.setName(username);
                user.setHighScore(0);
                String query2 = "INSERT INTO user VALUES (null, '" + user.getName() + "', '" + user.getHighScore() + "');";
                executeQuery(query2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur dans le SELECT");
        }
    }

    // On ne met à jour le score que s'il est plus élevé que celui déjà enregistré pour un utilisateur
    public static void updateUser(String username, int highScore) throws SQLException {
        String query = "UPDATE user SET user_score = '" + highScore +  "' WHERE user_name = '" + username + "'" +
                "AND user_score < '" + highScore + "';";
        executeQuery(query);
    }
}
