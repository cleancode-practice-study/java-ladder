package main.java.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResultCreator {
    private final List<String> players;
    private final List<Line> lines;
    private final List<String> prizes;

    public GameResultCreator(List<String> players, List<Line> lines, List<String> prizes) {
        this.players = players;
        this.lines = lines;
        this.prizes = prizes;
    }

    public Map<String, String> createGameResult() {
        Map<String, String> result = new HashMap<>();

        for (int i = 0; i < players.size(); i++) {
            int location = i;
            int height = 0;

            while (height < lines.size()) {
                location = upDateLocation(location, height);
                height++;
            }

            result.put(players.get(i), prizes.get(location));
        }

        return result;
    }

    private int upDateLocation(int location, int height) {
        int lastIdx = players.size() - 1;

        if (location == 0) {
            location = upDateRightLocation(location, height);
            return location;
        }

        if (location == lastIdx) {
            location = upDateLeftLocation(location, height);
            return location;
        }

        int newLocation = upDateRightLocation(location, height);
        if (location != newLocation)
            return newLocation;

        return upDateLeftLocation(location, height);
    }

    private int upDateRightLocation(int location, int height) {
        boolean right = lines.get(height).getPoints().get(location);

        if (right)
            location++;

        return location;
    }

    private int upDateLeftLocation(int location, int height) {
        boolean left = lines.get(height).getPoints().get(location - 1);

        if (left)
            location--;

        return location;
    }
}

