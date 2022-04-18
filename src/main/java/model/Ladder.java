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

    private int[] getLineCount(List<Line> lines) {
        int[] count = new int[width - 1];

        for (int i = 0; i < width - 1; i++) {
            count[i] = 0;
            for (int j = 0; j < height; j++) {
                Line line = lines.get(j);
                List<Boolean> points = line.getPoints();
                if (points.get(i))
                    count[i]++;
            }
        }

        return count;
    }

    private List<Line> createLadder(int width, int height) {
        List<Line> ladderLines;

        while (true) {
            ladderLines = new ArrayList<>();

            for (int i = 0; i < height; i++)
                ladderLines.add(new Line(width));

            int[] count = getLineCount(ladderLines);

            boolean replay = true;
            for (int i : count) {
                if (i != 0)
                    replay = false;
                else {
                    replay = true;
                    break;
                }
            }

            if (!replay)
                break;

        }

        return ladderLines;
    }

    public List<Line> getLadder() {
        return ladderHorizontals;
    }
}