package domain;

import java.util.List;

public class Ladder {
    List<Line> lines;
    int ladderHeight;
    int ladderWidth;

    public Ladder (List<Line> lines){
        this.lines = lines;
        this.ladderHeight = lines.size();
        this.ladderWidth = lines.get(0).getLineLength();
    }

    public boolean checkLadder() {
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
        int currentRowLine;
        int currentColumnLine;

        for (currentRowLine = startLine, currentColumnLine = 0 ; currentColumnLine < ladderHeight  ; ) {
            Line ladderLine = lines.get(currentColumnLine);
            List<Boolean> points = ladderLine.getLine();

            if (canMoveRight(currentRowLine, points)) {
                currentRowLine++;
            } else if (cantMoveRight(currentRowLine, points)) {
                currentRowLine--;
            }

            currentColumnLine++;
        }

        return outputs.getOutput(currentRowLine);
    }

    private boolean canMoveRight(int currentRowLine, List<Boolean> points) {
        return currentRowLine != ladderWidth && points.get(currentRowLine);
    }

    private boolean cantMoveRight(int currentRowLine, List<Boolean> points) {
        return currentRowLine != 0 && points.get(currentRowLine - 1);
    }
}
