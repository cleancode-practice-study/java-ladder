package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    private final static int PLAYER_NAME_LIMIT = 6;

    public static boolean checkContainComma(String names) {
        return names.contains(",");
    }

    public static boolean checkUnderFiveLetter(String names) {
        List<String> playerNames = LadderGame.splitNames(names);

        return playerNames.stream()
                .allMatch(name -> name.length() < PLAYER_NAME_LIMIT);
    }

    public static boolean checkIsMatchedWithPlayerCount(String outputNames, Players players) {
        List<String> outputs = Arrays.stream(outputNames.split(","))
                .collect(Collectors.toList());

        return outputs.size() == players.getPlayerCount();
    }

    public static boolean checkAllPrintCommand(String printCommand) {
        return printCommand.equals("all");
    }

    public static boolean checkPlayerName(String playerName, Players players) {
        return players.getPlayerNames()
                .stream()
                .anyMatch(name -> name.equals(playerName));
    }
}
