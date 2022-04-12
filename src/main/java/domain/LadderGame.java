package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {
    public static List<Player> getParticipantsByNames(String playerNames) {
        List<String> splitNames = splitNames(playerNames);

        List<Player> players = new ArrayList<>();

        for (String name : splitNames) {
            Player player = new Player(name);
            players.add(player);
        }

        return players;
    }

    private static List<String> splitNames(String names) {
        String[] participantsNames = names.split(",");
        return new ArrayList<>(Arrays.asList(participantsNames));
    }
}
