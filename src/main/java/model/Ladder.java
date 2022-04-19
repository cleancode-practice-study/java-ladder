package main.java.model;

import java.util.List;

public class Ladder {
    private final int width;
    private final int height;
    private final Lines lines;

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
        this.lines = new Lines(width, height);
    }

    public List<Line> getLadder() {
        return this.lines.getLines();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}