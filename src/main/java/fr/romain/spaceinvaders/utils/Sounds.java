package fr.romain.spaceinvaders.utils;

// On peut passer Sounds en Interface de manière à appeler ses propriétés plus facilement
// (plutôt que de passer par une classe, même abstraite)
public interface Sounds {

    String PATH = "File:./src/main/resources/fr/romain/spaceinvaders/sounds/";

    String BRICK_DESTRUCTION = PATH + "brickDestructionSound.wav";
    String SHIP_SHOT = PATH + "shipShotSound.wav";
    String ALIEN_DESTRUCTION = PATH + "alienDeadSound.wav";
    String SHIP_DESTRUCTION = PATH + "shipDestructionSound.wav";
    String ALIEN_SHOT1 = PATH + "alienShotSound1.wav";
    String ALIEN_SHOT2 = PATH + "alienShotSound2.wav";
    String ALIEN_SHOT3 = PATH + "alienShotSound3.wav";
    String ALIEN_SHOT4 = PATH + "alienShotSound4.wav";
    String SAUCER_PASSING = PATH + "saucerPassingSound.wav";
    String SAUCER_DESTRUCTION = PATH + "saucerDestructionSound.wav";
}
