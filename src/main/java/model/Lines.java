package main.java.model;

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
        boolean replay = true;

        do {
            lines = createRandomLines();
            List<Integer> count = createBridgesCount(lines);

            for (int i : count) {
                if (i == 0) {
                    replay = true;
                    break;
                }
                replay = false;
            }
        } while (!replay);

        return lines;
    }

    private List<Integer> createBridgesCount(List<Line> lines) {
        List<Integer> LinesCount = new ArrayList<>();

        for (int i = 0; i < width - 1; i++) {
            int cnt = 0;
            for (int j = 0; j < height; j++) {
                Line line = lines.get(j);
                List<Boolean> points = line.getPoints();
                if (points.get(i)) {
                    cnt++;
                }
            }
            LinesCount.add(cnt);
        }

        return LinesCount;
    }
}
