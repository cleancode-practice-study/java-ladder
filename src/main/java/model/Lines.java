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
        this.lines = createFinalLines(width, height);
    }

    public List<Line> getLines() {
        return this.lines;
    }

    private List<Line> createLines(int width, int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++)
            lines.add(new Line(width));

        return lines;
    }

    private List<Line> createFinalLines(int width, int height) {
        List<Line> lines;

        while (true) {
            lines = createLines(width, height);

            List<Integer> count = createLinesCount(lines);

            boolean replay = true;
            for (int i : count) {
                if (i == 0) {
                    replay = true;
                    break;
                }
                replay = false;

            }

            if (!replay) break;
        }

        return lines;
    }

    private List<Integer> createLinesCount(List<Line> lines) {
        List<Integer> LinesCount = new ArrayList<>();

        for (int i = 0; i < this.width - 1; i++) {
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
