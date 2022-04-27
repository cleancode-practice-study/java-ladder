package model;

import java.util.List;

public class Ladder {
    private final Lines lines;

    public Ladder(int playerCount, int height) {
        int width = playerCount - 1;
        this.lines = new Lines(width, height);
    }

    public List<Line> getLadder() {
        return this.lines.getLines();
    }
}