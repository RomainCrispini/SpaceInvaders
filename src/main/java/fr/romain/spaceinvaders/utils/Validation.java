package fr.romain.spaceinvaders.utils;

import java.util.regex.Pattern;

public class Validation {

    public static boolean getValidation(String input) {
        if (input.length() > 2 && Pattern.matches("[a-zA-Z]+", input)) {
            return true;
        }
        return false;
    }
}
