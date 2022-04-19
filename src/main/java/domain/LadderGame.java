package domain;

import java.util.*;

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

    public static GameResult getGameResult(Ladder ladder, Players players, Outputs outputs) {
        Map<Player, Output> result = new HashMap<>();
        // 사다리 타기 순서대로 한 명 씩..

        for (int i = 0 ; i < players.getPlayerCount() ; i++) {
            Player player = players.getPlayers().get(i);
            Output output = getEachLadderResult(i, ladder, outputs);

            result.put(player, output);
        }

        return new GameResult(result);
    }

    private static Output getEachLadderResult(int columnIndex, Ladder ladder, Outputs outputs) {
        Line line = ladder.getLines().get(0);
        int ladderWidth = line.getLine().size();
        int ladderHeight = ladder.getLadderHeight();

        int startLine;
        int j;

        for (startLine = columnIndex, j = 0 ; j < ladderHeight  ; ) {
            Line ladderLine = ladder.getLines().get(j);
            List<Boolean> points = ladderLine.getLine();

            // 현재 타는 라인의 오른쪽에 루트가 있는지
            if (startLine != ladderWidth && points.get(startLine)) {
                startLine++;
                j++;
                continue;
            }

            // 현재 타는 라인의 왼쪽에 루트가 있는지
            if (startLine != 0 && points.get(startLine - 1) ) {
                startLine--;
                j++;
                continue;
            }

            j++;
        }

        List<Output> output = outputs.getOutputs();

        return output.get(startLine);
    }

    public static Ladder getLadder(int playerCount, int maxLadderHeight) {
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
