package model;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final int width;
    private final int height;
    private final List<Line> lines;

    public Lines(int width, int height) {
        this.width = width;
        this.height = height;
        this.lines = createValidLines();
    }

    public List<Line> getLines() {
        return this.lines;
    }

    private List<Line> createRandomLines() {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++)
            lines.add(new Line(width));

        return lines;
    }

    private List<Line> createValidLines() {
        List<Line> lines;
        List<Integer> count;
        boolean replay = true;

        do {
            lines = createRandomLines();
            count = createBridgesCounts(lines);

            for (int i : count) {
                if (i == 0) {
                    replay = true;
                    break;
                }
                replay = false;
            }
        } while (replay);

        return lines;
    }

    private List<Integer> createBridgesCounts(List<Line> lines) {
        List<Integer> bridgesCounts = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            int bridgeCount = checkBridgeCount(lines, i);
            bridgesCounts.add(bridgeCount);
        }

        return bridgesCounts;
    }

    private int checkBridgeCount(List<Line> lines, int index) {
        int count = 0;

        for (int i = 0; i < height; i++) {
            Line line = lines.get(i);
            List<Boolean> points = line.getLine();
            count = upDateCount(points.get(index), count);
        }
        return count;
    }

    private int upDateCount(boolean point, int count) {
        if (point) {
            count++;
        }
        return count;
    }
}
