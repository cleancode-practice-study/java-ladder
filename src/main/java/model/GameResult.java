package main.java.model;

import java.util.Map;

public class GameResult {
    private final GameResultCreator gameResult;

    public GameResult(Players players, Ladder ladder, Prizes prizes) {
        this.gameResult = new GameResultCreator(players, ladder, prizes);
    }

    public Map<String, String> getGameResult() {
        return this.gameResult.getGameResult();
    }
}
