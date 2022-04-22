package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    List<Line> lines;

    public Ladder (int maxLadderHeight, int playerCount){
        lines = new ArrayList<>();
        IntStream.range(0, maxLadderHeight)
                .forEach(i -> lines.add(new Line(playerCount)));
    }

    public boolean checkLadder() {
        int lineRowLength = lines.get(0).LineLength();

        for (int i = 0 ; i < lineRowLength ; i++) {
            int rootCount = getRootCount(i);

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

    public Output getEachLadderResult(int startLine, Outputs outputs) {
        Line line = lines.get(0);
        int ladderWidth = line.getLine().size();
        int ladderHeight = lines.size();

        int currentRowLine;
        int currentColumnLine;

        for (currentRowLine = startLine, currentColumnLine = 0 ; currentColumnLine < ladderHeight  ; ) {
            Line ladderLine = lines.get(currentColumnLine);
            List<Boolean> points = ladderLine.getLine();

            if (canMoveRight(currentRowLine, ladderWidth, points)) {
                currentRowLine++;
            } else if (cantMoveRight(currentRowLine, points)) {
                currentRowLine--;
            }

            currentColumnLine++;
        }

        return outputs.getOutput(currentRowLine);
    }

    private boolean canMoveRight(int currentRowLine, int ladderWidth, List<Boolean> points) {
        return currentRowLine != ladderWidth && points.get(currentRowLine);
    }

    private boolean cantMoveRight(int currentRowLine, List<Boolean> points) {
        return currentRowLine != 0 && points.get(currentRowLine - 1);
    }
}
