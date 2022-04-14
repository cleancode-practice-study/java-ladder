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

    public void printLadder() {
        for (Line line : lines) {
            System.out.print("|");
            for (Boolean bool : line.getLine()) {
                if (bool) {
                    System.out.print("-----");
                } else {
                    System.out.print("     ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public boolean checkLadder() {
        int rootCount = 0;
        int lineLength = lines.get(0).getLine().size();

        for (int i = 0 ; i < lineLength ; i++) {
            for (int j = 0 ; j < lines.size() ; j++) {
                Line line = lines.get(j);
                if (line.getLine().get(i)) {
                    rootCount++;
                }
            }

            if (rootCount == 0) {
                return false;
            }
        }

        return true;
    }

    public List<Line> getLines() {
        return lines;
    }
}
