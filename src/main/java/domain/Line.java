package domain;

import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line (List<Boolean> points) {
        this.points = points;
    }

    private void addRoot(boolean previousRoot) {
        if (previousRoot) {
            points.add(false);
        }

        if (!previousRoot) {
            points.add(RandomRootCreator.getRandomRoot());
        }
    }

    public List<Boolean> getLine() {
        return points;
    }

    public int getLineLength() {
        return points.size();
    }
}
