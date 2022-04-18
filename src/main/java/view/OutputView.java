package view;

import domain.*;

import java.util.List;

public class OutputView {
    private static final String INPUT_NAMES_ERROR_MESSAGE = "[ERROR] 쉼표를 포함하여 올바르게 입력해주십시오.";
    private static final String INPUT_RESULT_ERROR_MESSAGE = "[ERROR] 참가자의 수와 동일한 수로 입력해주십시오.";
    private static final String INPUT_NAMES_LIMIT_ERROR_MESSAGE = "[ERROR] 참가자의 이름은 5자 이하로 입력해주십시오.";
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";

    public static void printInputNamesErrorMessage() {
        System.out.println(INPUT_NAMES_ERROR_MESSAGE);
    }

    public static void printInputResultErrorMessage() {
        System.out.println(INPUT_RESULT_ERROR_MESSAGE);
    }

    public static void printInputNamesLimitErrorMessage() {
        System.out.println(INPUT_NAMES_LIMIT_ERROR_MESSAGE);
    }

    public static void ladderResultMessage(Players players, Ladder ladder, Outputs outputs) {
        System.out.println();
        System.out.println(LADDER_RESULT_MESSAGE);
        System.out.println();

        printPlayerNames(players);
        printLadder(ladder);
        printOutputNames(outputs);
        System.out.println();
    }

    private static void printPlayerNames(Players players) {
        List<String> names = players.getPlayerNames();

        for (String name : names) {
            System.out.printf("%-7s", name);
        }

        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            System.out.print("    |");
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

    private static void printOutputNames(Outputs outputs) {
        List<String> outputNames = outputs.getOutputNames();

        for (String name : outputNames) {
            System.out.printf("%-7s", name);
        }

        System.out.println();
    }

    public static void printGameResult(Player player, GameResult gameResult) {
        System.out.println();
        System.out.println(GAME_RESULT_MESSAGE);
        System.out.println(gameResult.getResult(player));
        System.out.println();
    }
}
