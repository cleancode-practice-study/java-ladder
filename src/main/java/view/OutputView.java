package view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String GAME_RESULT_MESSAGE = "\n실행 결과";

    public static void printPlayersNames(List<String> players) {
        System.out.println("\n사다리 결과\n");
        for (String playerName : players)
            System.out.printf("%-8s", playerName);
        System.out.println(" ");
    }

    public static void printLine(List<Boolean> line) {
        System.out.print("  ");
        int lastIdx = line.size() - 1;

        for (int i = 0; i < line.size(); i++) {
            boolean point = line.get(i);
            printLinePoint(point, i, lastIdx);
        }

        System.out.println("");
    }

    public static void printPrizes(List<String> prizes) {
        for (String prize : prizes)
            System.out.printf("%-8s", prize);

        System.out.println("");
    }

    public static void printOnePeopleGameResult(Map<String, String> gameResult, String name) {
        System.out.println(GAME_RESULT_MESSAGE);
        System.out.println(gameResult.get(name));
    }

    public static void printAllGameResult(Map<String, String> gameResult) {
        System.out.println(GAME_RESULT_MESSAGE);
        for (String name : gameResult.keySet())
            System.out.println(name + " : " + gameResult.get(name));
    }

    private static void printLinePoint(boolean point, int pointIdx, int lastIdx) {
        if (point) {
            if (pointIdx != lastIdx) {
                System.out.print("| ----- ");
                return;
            }
            System.out.print("| ----- |");
            return;
        }

        if (pointIdx != lastIdx) {
            System.out.print("|       ");
            return;
        }
        System.out.print("|       |");
    }
}
