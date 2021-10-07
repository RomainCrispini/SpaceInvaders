package fr.romain.spaceinvaders.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    private final String DB = "space_invaders";
    private final String USER = "root";
    private final String PORT = "3307";
    private final String PASSWORD = "MariaDBRomain1895+";
    //private final String URL = "jdbc:mysql://localhost:" + SOCKET + "/" + DB; <---- mySQL
    private final String URL = "jdbc:mariadb://192.168.1.20.%:" + PORT + "/" + DB; // <--- MariaDB
    private Connection databaseLink;

    public Connection getConnection() {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver"); <--- mySQL
            Class.forName("org.mariadb.jdbc.Driver"); // <--- MariaDB
            databaseLink = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connecté !!!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de Connection");
        }
        return databaseLink;
    }
}
