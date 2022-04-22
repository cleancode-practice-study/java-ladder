package model;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(int width, int height) {
        this.lines = createValidLines(width, height);
    }

    public List<Line> getLines() {
        return this.lines;
    }

    private List<Line> createValidLines(int width, int height) {
        List<Line> lines;
        List<Integer> count;
        boolean replay = true;

        do {
            lines = createRandomLines(width, height);
            count = createBridgesCounts(lines, width, height);

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

    private List<Line> createRandomLines(int width, int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++)
            lines.add(new Line(width));

        return lines;
    }

    private List<Integer> createBridgesCounts(List<Line> lines, int width, int height) {
        List<Integer> bridgesCounts = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            int bridgeCount = getBridgeCount(lines, i, height);
            bridgesCounts.add(bridgeCount);
        }

        return bridgesCounts;
    }

    private int getBridgeCount(List<Line> lines, int index, int height) {
        int count = 0;

        for (int i = 0; i < height; i++) {
            Line line = lines.get(i);
            List<Boolean> points = line.getLine();
            count = upDateBridgeCount(points, index, count);
        }

        return count;
    }

    private int upDateBridgeCount(List<Boolean> points, int index, int count) {
        if (points.get(index))
            count++;

        return count;
    }
}
