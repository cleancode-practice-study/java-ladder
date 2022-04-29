package domain;

import java.util.*;
import java.util.stream.Collectors;

public class LadderGame {
    public static Players createParticipantsByNames(String playerNames) {
        List<String> splitNames = splitNames(playerNames);

        List<Player> players = splitNames
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());

        return new Players(players);
    }

    public static List<String> splitNames(String names) {
        return Arrays.stream(names.split(","))
                .collect(Collectors.toList());
    }

    public static Outputs createOutputsByInput(String outputNames) {
        List<String> splitOutputs = splitNames(outputNames);

        List<Output> outputs = splitOutputs
                .stream()
                .map(Output::new)
                .collect(Collectors.toList());

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
            ladder = new Ladder(RandomLadderCreator.getRandomLadder(playerCount, maxLadderHeight));
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
}
