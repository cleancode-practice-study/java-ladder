package main.java.model;

public class Validator {
    public static boolean isValidPlayerNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > 5)
                return false;
        }
        return true;
    }

    public static boolean isValidPlayersLength(String[] names) {
        return names.length >= 2;
    }

    public static boolean isValidResultsLength(int resultsLength, int playersLength) {
        return resultsLength == playersLength;
    }
}
