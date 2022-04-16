package view;

import domain.Ladder;
import domain.Line;

import java.util.List;

public class OutputView {
    private static final String INPUT_NAMES_ERROR_MESSAGE = "[ERROR] 쉼표를 포함하여 올바르게 입력해주십시오.";
    private static final String INPUT_RESULT_ERROR_MESSAGE = "[ERROR] 참가자의 수와 동일한 수로 입력해주십시오.";
    private static final String INPUT_NAMES_LIMIT_ERROR_MESSAGE = "[ERROR] 참가자의 이름은 5자 이하로 입력해주십시오.";
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";

    public static void printInputNamesErrorMessage() {
        System.out.println(INPUT_NAMES_ERROR_MESSAGE);
    }

    public static void printInputResultErrorMessage() {
        System.out.println(INPUT_RESULT_ERROR_MESSAGE);
    }

    public static void printInputNamesLimitErrorMessage() {
        System.out.println(INPUT_NAMES_LIMIT_ERROR_MESSAGE);
    }

    public static void ladderResultMessage(Ladder ladder) {
        System.out.println();
        System.out.println(LADDER_RESULT_MESSAGE);
        System.out.println();
        printLadder(ladder);
    }

    private static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
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
}
