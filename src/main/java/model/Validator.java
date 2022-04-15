package main.java.model;

public class Validator {
    public static boolean isPlayerNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > 5)
                return false;
        }
        return true;
    }
}
