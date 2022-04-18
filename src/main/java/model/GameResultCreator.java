package main.java.model;

import java.util.HashMap;
import java.util.Map;

public class GameResultCreator {
    private final Players players;
    private final Ladder ladder;
    private final Results results;

    public GameResultCreator(Players players, Ladder ladder, Results results) {
        this.players = players;
        this.ladder = ladder;
        this.results = results;
    }

    public Map<String, String> getGameResult() {
        Map<String, String> result = new HashMap<>();

        for (int i = 0; i < ladder.getWidth(); i++) { // width, player 순서대로
            int location = i; // 해당 player 실시간 위치
            int height = 0;
            while (height < ladder.getHeight()) {
                if (location == 0) {
                    if (ladder.getLadder().get(height).getPoints().get(location)) {
                        location++;
                        height++;
                    } else
                        height++;

                } else if (location == ladder.getWidth() - 1) {
                    if (ladder.getLadder().get(height).getPoints().get(location - 1)) {
                        location--;
                        height++;
                    } else
                        height++;
                } else {
                    if (ladder.getLadder().get(height).getPoints().get(location - 1)) { // 사다리에서 왼쪽 line
                        location--;
                        height++;
                    } else if (ladder.getLadder().get(height).getPoints().get(location)) { // 사다리에서 오른쪽 line
                        location++;
                        height++;
                    } else
                        height++;
                }
            }

            result.put(players.getPlayers().get(i).getName(), results.getResults().get(location).getPrize());
        }

        return result;
    }
}

