module fr.romain.spaceinvaders {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires mysql.connector.java;
    requires org.mariadb.jdbc;

    opens fr.romain.spaceinvaders.entities to javafx.base;
    opens fr.romain.spaceinvaders to javafx.fxml;
    exports fr.romain.spaceinvaders;
}