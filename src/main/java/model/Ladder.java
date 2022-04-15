package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> ladderHorizontals = new ArrayList<>();
    private final int width;
    private final int height;

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
        this.ladderHorizontals = createLadder(width, height);
    }

    private List<Line> createLadder(int width, int height) {
        List<Line> ladderLines = new ArrayList<>();
        for (int i = 0; i < height; i++)
            ladderLines.add(new Line(width));

        return ladderLines;
    }

    public List<Line> getLadder(){
        return ladderHorizontals;
    }
}
