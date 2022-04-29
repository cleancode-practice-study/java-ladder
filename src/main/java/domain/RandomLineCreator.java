package domain;

import java.util.ArrayList;
import java.util.List;

public class RandomLineCreator {
    public List<Boolean> getLine (int playerCount) {
        List<Boolean> points = new ArrayList<>();

        addRoot(points, RandomRootCreator.getRandomRoot());

        for (int i = 1 ; i < playerCount - 1 ; i++) {
            boolean previousRoot = points.get(i - 1);
            addRoot(points, previousRoot);
        }

        return points;
    }

    private void addRoot(List<Boolean> points, boolean previousRoot) {
        if (previousRoot) {
            points.add(false);
        }

        if (!previousRoot) {
            points.add(RandomRootCreator.getRandomRoot());
        }
    }
}
