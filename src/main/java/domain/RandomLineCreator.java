package domain;

import java.util.ArrayList;
import java.util.List;

public class RandomLineCreator {
    private final List<Boolean> points = new ArrayList<>();

    public List<Boolean> getLine (int playerCount) {
        addRoot(RandomRootCreator.getRandomRoot());

        for (int i = 1 ; i < playerCount - 1 ; i++) {
            boolean previousRoot = points.get(i - 1);
            addRoot(previousRoot);
        }

        return points;
    }

    private void addRoot(boolean previousRoot) {
        if (previousRoot) {
            points.add(false);
        }

        if (!previousRoot) {
            points.add(RandomRootCreator.getRandomRoot());
        }
    }
}
