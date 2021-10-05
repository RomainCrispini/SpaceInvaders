package fr.romain.spaceinvaders.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    private final String DB = "space_invaders";
    private final String USER = "root";
    private final String SOCKET = "8889";
    private final String PASSWORD = "root";
    private final String URL = "jdbc:mysql://localhost:" + SOCKET + "/" + DB;
    private Connection databaseLink;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connecté !!!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de Connection");
        }
        return databaseLink;
    }

}
