package domain;

import java.util.List;

public class Ladder {
    List<Line> lines;

    public Ladder (List<Line> lines){
        this.lines = lines;
    }

    public boolean checkLadder() {
        int ladderWidth = getLadderWidth();

        for (int i = 0 ; i < ladderWidth ; i++) {
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
        int ladderHeight = getLadderHeight();
        int ladderWidth = getLadderWidth();

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

    private int getLadderHeight() {
        return lines.size();
    }

    private int getLadderWidth() {
        return lines.get(0).getLineLength();
    }
}
