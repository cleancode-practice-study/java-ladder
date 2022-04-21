package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> line;

    public Line(int width) {
        this.line = createLine(width);
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
        for (int i = 0; i < points.size(); i++)
            modifyPoint(points, i);

        return points;
    }

    private boolean isValidPoints(List<Boolean> points, int index) {
        return points.get(index) && points.get(index + 1);
    }

    private void modifyPoint(List<Boolean> points, int pointIdx) {
        int lastIdx = points.size() - 1;
        if (pointIdx != lastIdx && isValidPoints(points, pointIdx)) {
            points.set(pointIdx + 1, false);
        }
    }
}