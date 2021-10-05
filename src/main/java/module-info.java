module fr.romain.spaceinvaders {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires mysql.connector.java;

    opens fr.romain.spaceinvaders.entities to javafx.base;
    opens fr.romain.spaceinvaders to javafx.fxml;
    exports fr.romain.spaceinvaders;
}