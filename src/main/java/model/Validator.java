package main.java.model;

public class Validator {

    public static final int PLAYER_NAME_STANDARD_LENGTH = 5;
    public static final int PLAYER_MIN_COUNT = 2;

    public static boolean isValidPlayerNameLength(String[] names) {
        for (String name : names)
            if (name.length() > PLAYER_NAME_STANDARD_LENGTH) return false;
        return true;
    }

    public static boolean isValidPlayersCount(String[] names) {
        return names.length >= PLAYER_MIN_COUNT;
    }

    public static boolean isValidResultsCount(int resultsLength, int playersLength) {
        return resultsLength == playersLength;
    }

}
