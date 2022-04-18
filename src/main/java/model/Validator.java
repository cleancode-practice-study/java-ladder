package main.java.model;

public class Validator {
    public static boolean isValidPlayerNameLength(String[] names) {
        for (String name : names)
            if (name.length() > 5) return false;
        return true;
    }

    public static boolean isValidPlayerCount(String[] names) {
        return names.length >= 2;
    }

    public static boolean isValidResultCount(int resultsLength, int playersLength) {
        return resultsLength == playersLength;
    }

}
