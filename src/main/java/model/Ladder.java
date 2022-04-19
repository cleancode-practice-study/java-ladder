package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> ladderHorizontals;
    private final int width;
    private final int height;

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
        this.ladderHorizontals = createLadder(width, height);
    }

    public List<Line> getLadder() {
        return ladderHorizontals;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    private List<Line> createLines(int width, int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++)
            lines.add(new Line(width));

        return lines;
    }

    private List<Line> createLadder(int width, int height) {
        List<Line> lines;

        while (true) {
            lines = createLines(width, height);

            int[] count = getLinesCount(lines);
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

    private int[] getLinesCount(List<Line> lines) {
        int[] count = new int[width - 1];

        for (int i = 0; i < width - 1; i++) {
            count[i] = 0;
            for (int j = 0; j < height; j++) {
                Line line = lines.get(j);
                List<Boolean> points = line.getPoints();
                if (points.get(i)) count[i]++;
            }
        }

        return count;
    }
}