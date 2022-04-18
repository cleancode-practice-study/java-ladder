package main.java.model;

import java.util.Map;

public class GameResult {
    private final GameResultCreator gameResultCreator;

    public GameResult(GameResultCreator gameResultCreator) {
        this.gameResultCreator = gameResultCreator;
    }

    public Map<String, String> getGameResult() {
        return this.gameResultCreator.getGameResult();
    }
}
