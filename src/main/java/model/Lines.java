package model;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(int width, int height) {
        this.lines = createValidLines(width, height);
    }

    private List<Line> createValidLines(int width, int height) {
        List<Line> lines;
        boolean replay;

        do {
            lines = createRandomLines(width, height);
            List<Integer> count = calculateBridgesCounts(lines, width, height);

            replay = count.stream().anyMatch(bridgeCount -> bridgeCount == 0);
        } while (replay);

        return lines;
    }

    private List<Line> createRandomLines(int width, int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++)
            lines.add(new Line(width));

        return lines;
    }

    private List<Integer> calculateBridgesCounts(List<Line> lines, int width, int height) {
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
            count = updateBridgeCount(points.get(index), count);
        }

        return count;
    }

    private int updateBridgeCount(boolean point, int count) {
        return point ? count + 1 : count;
    }

    public List<Line> getLines() {
        return this.lines;
    }

}
