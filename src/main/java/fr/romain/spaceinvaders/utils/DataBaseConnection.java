package fr.romain.spaceinvaders.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    private final String DB = "space_invaders";

    private final String USER = "root"; // <---- mySQL
    private final String PORT = "8889"; // <---- mySQL
    private final String PASSWORD = "root"; // <---- mySQL
    private final String URL = "jdbc:mysql://localhost:" + PORT + "/" + DB; // <---- mySQL

    // private final String USER = "root"; // <---- MariaDB
    //private final String PORT = "3307"; // <--- MariaDB
    //private final String PASSWORD = "MariaDBRomain1895+"; // <--- MariaDB
    //private final String URL = "jdbc:mariadb://192.168.1.20.%:" + PORT + "/" + DB; // <--- MariaDB

    private Connection databaseLink;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // <--- mySQL
            //Class.forName("org.mariadb.jdbc.Driver"); // <--- MariaDB
            databaseLink = DriverManager.getConnection(URL, USER, PASSWORD); // <--- mySQL
            //databaseLink = DriverManager.getConnection("jdbc:mariadb://192.168.1.20.%:3307/space_invaders?user=root&password=MariaRomain123+"); // <--- MariaDB
            System.out.println("Connecté !!!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de Connection");
        }
        return databaseLink;
    }
}
