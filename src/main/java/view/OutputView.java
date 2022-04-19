package main.java.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printPlayerNameLengthErrorMessage() {
        System.out.println("이름은 최대 5글자까지 입력할 수 있습니다. 다시 입력 해 주세요.");
    }

    public static void printPlayerCountErrorMessage() {
        System.out.println("두명 이상 입력 해 주세요. \n");
    }

    public static void printPrizeCountErrorMessage(int playersCount) {
        System.out.println(playersCount + "개의 실행 결과를 입력 해 주세요.");
    }

    public static void printPlayerErrorMessage() {
        System.out.println("해당 플레이어는 존재하지 않습니다. \n다시 입력 해 주세요.");
    }

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
            printPoint(point, i, lastIdx);
        }

        System.out.println("");
    }

    private static void printPoint(boolean point, int pointIdx, int lastIdx) {
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

    public static void printPrizes(List<String> prizes) {
        for (String prize : prizes)
            System.out.printf("%-8s", prize);

        System.out.println("");
    }

    public static void printOnePeopleGameResult(Map<String, String> gameResult, String name) {
        System.out.println("\n실행 결과");
        System.out.println(gameResult.get(name));
    }

    public static void printAllGameResult(Map<String, String> gameResult) {
        System.out.println("\n실행 결과");
        for (String name : gameResult.keySet())
            System.out.println(name + " : " + gameResult.get(name));
    }
}
