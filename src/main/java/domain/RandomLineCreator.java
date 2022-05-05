package domain;

import java.util.ArrayList;
import java.util.List;

public class RandomLineCreator {
    public List<Boolean> getLine (int playerCount, RootCreator rootCreator) {
        List<Boolean> points = new ArrayList<>();

        addRoot(points, rootCreator, rootCreator.createRoot());

        for (int i = 1 ; i < playerCount - 1 ; i++) {
            boolean previousRoot = points.get(i - 1);
            addRoot(points, rootCreator, previousRoot);
        }

        return points;
    }

    private void addRoot(List<Boolean> points, RootCreator rootCreator, boolean previousRoot) {
        if (previousRoot) {
            points.add(false);
        }

        if (!previousRoot) {
            points.add(rootCreator.createRoot());
        }
    }
}
