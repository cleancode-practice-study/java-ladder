package domain;

import java.util.ArrayList;

public class Line {
    private final ArrayList<Boolean> points = new ArrayList<>();

    public Line (int playerCount) {
        addRoot(RandomRootCreator.getRandomRoot());

        for (int i = 1 ; i < playerCount ; i++) {
            boolean previousRoot = points.get(i - 1);
            addRoot(previousRoot);
        }
    }

    private void addRoot(boolean previousRoot) {
        if (previousRoot) {
            points.add(false);
        }

        if (!previousRoot) {
            points.add(RandomRootCreator.getRandomRoot());
        }
    }

    public ArrayList<Boolean> getLine() {
        return points;
    }
}
