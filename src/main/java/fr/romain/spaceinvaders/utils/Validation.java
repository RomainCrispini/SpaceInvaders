package fr.romain.spaceinvaders.utils;

import java.util.regex.Pattern;

public class Validation {

    public static boolean getHomeNameValidation(String input) {
        return input.length() > 2 && Pattern.matches("[a-zA-Z]+", input);
    }
}
