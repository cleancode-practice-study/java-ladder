package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResultCreator {
    private final Map<String, String> gameResult;

    public GameResultCreator(List<String> players, List<Line> lines, List<String> prizes) {
        this.gameResult = createGameResult(players, lines, prizes);
    }

    public Map<String, String> getGameResult() {
        return this.gameResult;
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
            location = updateRightDirection(line, location);
            return location;
        }

        if (location == lastIdx) {
            location = updateLeftDirection(line, location);
            return location;
        }

        int newLocation = updateRightDirection(line, location);
        if (location != newLocation) {
            return newLocation;
        }

        return updateLeftDirection(line, location);
    }

    private int updateRightDirection(Line line, int location) {
        List<Boolean> points = line.getLine();
        boolean rightPoint = points.get(location);

        if (rightPoint) {
            location++;
        }

        return location;
    }

    private int updateLeftDirection(Line line, int location) {
        List<Boolean> points = line.getLine();
        boolean leftPoint = points.get(location - 1);

        if (leftPoint) {
            location--;
        }

        return location;
    }
}

