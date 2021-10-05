package fr.romain.spaceinvaders.entities;

public class User {

    private String name;
    private int highScore;

    public User(String name, int highScore) {
        this.name = name;
        this.highScore = highScore;
    }

    public User() {}

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
