package main.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> line;

    public Line(int playerCount) {
        int pointCount = playerCount - 1;
        this.line = createLine(pointCount);
    }

    public List<Boolean> getPoints() {
        return this.line;
    }

    private List<Boolean> createLine(int pointCount) {
        Random random = new Random();
        List<Boolean> points = new ArrayList<>();

        for (int i = 0; i < pointCount; i++)
            points.add(random.nextBoolean());

        return createValidLine(points);
    }

    private List<Boolean> createValidLine(List<Boolean> points) {
        for (int i = 0; i < points.size(); i++) {
            int lastIdx = points.size() - 1;
            if (i != lastIdx && isValidPoints(points, i))
                points.set(i + 1, false);
        }

        return points;
    }

    private boolean isValidPoints(List<Boolean> points, int index) {
        return points.get(index) && points.get(index + 1);
    }
}
