package domain;

import java.util.Map;

public class GameResult {
    Map<Player, Output> gameResult;

    public GameResult(Map<Player, Output> gameResult) {
        this.gameResult = gameResult;
    }

    public void printResult() {
        for (Player player : gameResult.keySet()) {
            System.out.println(player.getName() + " : " + gameResult.get(player).getOutputName());
        }
    }
}
