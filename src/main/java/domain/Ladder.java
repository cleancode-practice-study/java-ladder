package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    List<Line> lines;

    // 최대 사다리 높이 만큼 라인(라인의 넓이는 playerCount)을 쌓는다.
    public Ladder (int maxLadderHeight, int playerCount){
        lines = new ArrayList<>();
        for (int i = 0 ; i < maxLadderHeight ; i++) {
            lines.add(new Line(playerCount));
        }
    }

    public boolean checkLadder() {
        int rootCount;
        int lineRowLength = lines.get(0).getLine().size();

        for (int i = 0 ; i < lineRowLength ; i++) {
            rootCount = getRootCount(i);

            if (rootCount == 0) {
                return false;
            }
        }

        return true;
    }

    private int getRootCount(int columnIndex) {
        int rootCount = 0;

        for (Line line : lines) {
            if (line.getLine().get(columnIndex)) {
                rootCount++;
            }
        }
        return rootCount;
    }

    public List<Line> getLines() {
        return lines;
    }
}
