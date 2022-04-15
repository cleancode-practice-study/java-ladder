package main.java.view;

import main.java.model.Ladder;
import main.java.model.Line;

import java.util.ArrayList;

public class OutputView {
    public static void printPlayersNamesInputMessage() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void printLadderResultsInputMessage() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public static void printMaxHeightInputMessage() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printLine(ArrayList<Boolean> line) {
        for (int i = 0; i < line.size(); i++) {
            if (i != line.size() - 1) {
                if (line.get(i))
                    System.out.print("| ----- ");
                else {
                    System.out.print("|       ");
                }
            } else {
                if (line.get(i)) {
                    System.out.print("| ----- |");
                } else {
                    System.out.print("|       |");
                }

            }
        }

    }

    public static void printLadder(Ladder ladder){
        for (Line line : ladder.getLadder()) {
            OutputView.printLine(line.getPoints());
            System.out.println("");
        }
    }
}
