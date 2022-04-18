package main.java.model;

import java.util.Map;

public class GameResult {
    private final GameResultCreator gameResult;

    public GameResult(GameResultCreator gameResult) {
        this.gameResult = gameResult;
    }

    public Map<String, String> getGameResult() {
        return this.gameResult.getGameResult();
    }
}
