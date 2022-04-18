package domain;

import java.util.Map;

public class GameResult {
    Map<Player, Output> gameResult;

    public GameResult(Map<Player, Output> gameResult) {
        this.gameResult = gameResult;
    }

    public String getResult(Player player) {
        return gameResult.get(player).getOutputName();
    }
}
