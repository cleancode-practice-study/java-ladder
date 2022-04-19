package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    List<Line> lines;

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

    public Output getEachLadderResult(int startLine, Outputs outputs) {
        Line line = lines.get(0);
        int ladderWidth = line.getLine().size();
        int ladderHeight = lines.size();

        int currentRowLine;
        int currentColumnLine;

        for (currentRowLine = startLine, currentColumnLine = 0 ; currentColumnLine < ladderHeight  ; ) {
            Line ladderLine = lines.get(currentColumnLine);
            List<Boolean> points = ladderLine.getLine();

            if (currentRowLine != ladderWidth && points.get(currentRowLine)) {
                currentRowLine++;
            } else if (currentRowLine != 0 && points.get(currentRowLine - 1) ) {
                currentRowLine--;
            }

            currentColumnLine++;
        }

        List<Output> output = outputs.getOutputs();

        return output.get(currentRowLine);
    }
}
