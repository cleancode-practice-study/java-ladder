package model;

import java.util.List;

public class Ladder {
    private final Lines lines;

    public Ladder(int playerCount, int height) {
        this.lines = new Lines(playerCount - 1, height);
    }

    public List<Line> getLadder() {
        return this.lines.getLines();
    }
}