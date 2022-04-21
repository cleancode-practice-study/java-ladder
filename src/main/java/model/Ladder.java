package model;

import java.util.List;

public class Ladder {
    private final Lines lines;

    public Ladder(int width, int height) {
        this.lines = new Lines(width, height);
    }

    public List<Line> getLadder() {
        return this.lines.getLines();
    }
}