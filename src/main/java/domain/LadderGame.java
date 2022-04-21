package domain;

import java.util.*;
import java.util.stream.Collectors;

public class LadderGame {
    public static Players getParticipantsByNames(String playerNames) {
        List<String> splitNames = splitNames(playerNames);

        List<Player> players = new ArrayList<>();

        for (String name : splitNames) {
            Player player = new Player(name);
            players.add(player);
        }

        return new Players(players);
    }

    public static List<String> splitNames(String names) {
        return Arrays.stream(names.split(",")).collect(Collectors.toList());
    }

    public static Outputs getOutputs(String outputNames) {
        List<String> splitOutputs = splitNames(outputNames);

        List<Output> outputs = new ArrayList<>();

        for (String output : splitOutputs) {
            outputs.add(new Output(output));
        }

        return new Outputs(outputs);
    }

    public static GameResult getGameResult(Ladder ladder, Players players, Outputs outputs) {
        Map<Player, Output> result = new HashMap<>();

        for (int columnIndex = 0 ; columnIndex < players.getPlayerCount() ; columnIndex++) {
            Player player = players.getPlayers().get(columnIndex);
            Output output = ladder.getEachLadderResult(columnIndex, outputs);

            result.put(player, output);
        }

        return new GameResult(result);
    }

    public static Ladder createLadder(int playerCount, int maxLadderHeight) {
        Ladder ladder;

        do {
            ladder = new Ladder(maxLadderHeight, playerCount);
        } while (!ladder.checkLadder());

        return ladder;
    }

    public static Player findPlayer(String playerName, Players players) {
        for (Player player : players.getPlayers()) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }

        return null;
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
