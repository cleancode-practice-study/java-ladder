package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        String[] participantsNames = names.split(",");
        return new ArrayList<>(Arrays.asList(participantsNames));
    }

    public static Outputs getOutputs(String outputNames) {
        List<String> splitOutputs = splitNames(outputNames);

        List<Output> outputs = new ArrayList<>();

        for (String output : splitOutputs) {
            outputs.add(new Output(output));
        }

        return new Outputs(outputs);
    }
}
