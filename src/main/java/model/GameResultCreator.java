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
            int location = i;
            int height = 0;

            while (height < lines.size()) {
                Line line = lines.get(height);
                location = updateLocation(players, line, location);
                height++;
            }

            String playerName = players.get(i);
            String prize = prizes.get(location);
            gameResult.put(playerName, prize);
        }

        return gameResult;
    }

    private int updateLocation(List<String> players, Line line, int location) {
        int lastIdx = players.size() - 1;

        if (location == 0) {
            location = updateRightLocation(line, location);
            return location;
        }

        if (location == lastIdx) {
            location = updateLeftLocation(line, location);
            return location;
        }

        int newLocation = updateRightLocation(line, location);
        if (location != newLocation) {
            return newLocation;
        }

        return updateLeftLocation(line, location);
    }

    private int updateRightLocation(Line line, int location) {
        List<Boolean> points = line.getLine();
        boolean rightPoint = points.get(location);

        if (rightPoint) {
            location++;
        }

        return location;
    }

    private int updateLeftLocation(Line line, int location) {
        List<Boolean> points = line.getLine();
        boolean leftPoint = points.get(location - 1);

        if (leftPoint) {
            location--;
        }

        return location;
    }
}

