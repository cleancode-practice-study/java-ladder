package model;

import java.util.Map;

public class GameResult {
    private final Map<String, String> gameResult;

    public GameResult(Map<String, String> gameResult) {
        this.gameResult = gameResult;
    }

    public Map<String, String> getGameResult() {
        return this.gameResult;
    }
}
