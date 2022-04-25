package domain;

import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line (List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getLine() {
        return points;
    }

    public int getLineLength() {
        return points.size();
    }
}
