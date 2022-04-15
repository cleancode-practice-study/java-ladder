package main.java.model;

public class Validator {
    public static boolean isPlayerNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > 5)
                return false;
        }
        return true;
    }

    public static boolean isPlayersLength(String[] names) {
        if (names.length < 2)
            return false;
        return true;
    }
}
