module fr.romain.spaceinvaders {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens fr.romain.spaceinvaders to javafx.fxml;
    exports fr.romain.spaceinvaders;
}