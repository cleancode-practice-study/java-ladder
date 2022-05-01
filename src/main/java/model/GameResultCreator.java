package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResultCreator {
    private final Map<String, String> gameResult;

    public GameResultCreator(List<String> players, List<Line> lines, List<String> prizes) {
        this.gameResult = createGameResult(players, lines, prizes);
    }

    private Map<String, String> createGameResult(List<String> players, List<Line> lines, List<String> prizes) {
        Map<String, String> gameResult = new HashMap<>();

        for (int i = 0; i < players.size(); i++) {
            int finalPlayerLocationIdx = findFinalPlayerLocationIdx(lines, i);

            String playerName = players.get(i);
            String prize = prizes.get(finalPlayerLocationIdx);
            gameResult.put(playerName, prize);
        }

        return gameResult;
    }

    private int findFinalPlayerLocationIdx(List<Line> lines, int playerStartIdx) {
        int location = playerStartIdx;
        int height = 0;

        while (height < lines.size()) {
            Line line = lines.get(height);
            location = updateLocation(line, location);
            height++;
        }

        return location;
    }

    private int updateLocation(Line line, int location) {
        int lastIdx = line.getLine().size();

        if (location == 0) {
            location = updateRightDirection(line.getLine(), location);
            return location;
        }

        if (location == lastIdx) {
            location = updateLeftDirection(line.getLine(), location);
            return location;
        }

        int newLocation = updateRightDirection(line.getLine(), location);
        if (location != newLocation) {
            return newLocation;
        }

        return updateLeftDirection(line.getLine(), location);
    }

    private int updateRightDirection(List<Boolean> points, int location) {
        boolean rightPoint = points.get(location);
        return rightPoint ? location + 1 : location;
    }

    private int updateLeftDirection(List<Boolean> points, int location) {
        boolean leftPoint = points.get(location - 1);
        return leftPoint ? location - 1:location;
    }

    public Map<String, String> getGameResult() {
        return this.gameResult;
    }
}

