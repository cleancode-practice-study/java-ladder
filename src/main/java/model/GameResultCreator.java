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
                location = upDateLocation(players, lines, location, height);
                height++;
            }

            String playerName = players.get(i);
            String prize = prizes.get(location);
            gameResult.put(playerName, prize);
        }

        return gameResult;
    }

    private int upDateLocation(List<String> players, List<Line> lines, int location, int height) {
        int lastIdx = players.size() - 1;

        if (location == 0) {
            location = upDateRightLocation(lines, location, height);
            return location;
        }

        if (location == lastIdx) {
            location = upDateLeftLocation(lines, location, height);
            return location;
        }

        int newLocation = upDateRightLocation(lines, location, height);
        if (location != newLocation) {
            return newLocation;
        }

        return upDateLeftLocation(lines, location, height);
    }

    private int upDateRightLocation(List<Line> lines, int location, int height) {
        Line line = lines.get(height);
        List<Boolean> points = line.getLine();
        boolean rightPoint = points.get(location);

        if (rightPoint) {
            location++;
        }

        return location;
    }

    private int upDateLeftLocation(List<Line> lines, int location, int height) {
        Line line = lines.get(height);
        List<Boolean> points = line.getLine();
        boolean leftPoint = points.get(location - 1);

        if (leftPoint) {
            location--;
        }

        return location;
    }
}

