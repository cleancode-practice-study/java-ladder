package model;

import java.util.Arrays;

public class Validator {
    public static final int PLAYER_NAME_STANDARD_LENGTH = 5;
    public static final int PLAYER_MIN_COUNT = 2;

    public static boolean isValidPlayerNameLength(String[] names) {
        return Arrays.stream(names)
                .allMatch(name -> name.length() <= PLAYER_NAME_STANDARD_LENGTH);
    }

    public static boolean isValidPlayerCount(String[] names) {
        return PLAYER_MIN_COUNT <= names.length;
    }

    public static boolean isValidPrizeCount(int prizesCount, int playersCount) {
        return prizesCount == playersCount;
    }
}
