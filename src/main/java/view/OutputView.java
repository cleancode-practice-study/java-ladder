package main.java.view;

import main.java.model.Line;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static void printPlayersNames(List<String> players) {
        for (String playerName : players)
            System.out.printf("%-8s", playerName);
    }

    private static void printLine(List<Boolean> points) {
        for (int i = 0; i < points.size(); i++) {
            if (i != points.size() - 1) {
                if (points.get(i)) {
                    System.out.print("| ----- ");
                } else {
                    System.out.print("|       ");
                }
            } else {
                if (points.get(i)) {
                    System.out.print("| ----- |");
                } else {
                    System.out.print("|       |");
                }
            }
        }
    }

    private static void printLadderResults(List<String> prizes) {
        for (String prize : prizes)
            System.out.printf("%-8s", prize);

        System.out.println("");
    }

    public static void printLadder(List<String> players, List<Line> ladder, List<String> prizes) {
        System.out.println("\n사다리 결과\n");
        printPlayersNames(players);
        System.out.println(" ");

        for (Line line : ladder) {
            System.out.print("  ");
            printLine(line.getPoints());
            System.out.println("");
        }
        printLadderResults(prizes);
    }

    public static void printPlayerNameLengthErrorMessage() {
        System.out.println("이름은 최대 5글자까지 입력할 수 있습니다. 다시 입력 해 주세요.");
    }

    public static void printPlayersCountErrorMessage() {
        System.out.println("두명 이상 입력 해 주세요. \n");
    }

    public static void printResultsCountErrorMessage(int playersCount) {
        System.out.println(playersCount + "개의 실행 결과를 입력 해 주세요.");
    }

    public static void printGameResultErrorMessage() {
        System.out.println("해당 플레이어는 존재하지 않습니다. \n다시 입력 해 주세요.");
    }

    public static void printPeopleResult(Map<String, String> gameResult, String name) {
        System.out.println("\n실행 결과");
        System.out.println(gameResult.get(name));
    }

    public static void printAllPeopleResult(Map<String, String> gameResult) {
        System.out.println("\n실행 결과");
        for (String name : gameResult.keySet())
            System.out.println(name + " : " + gameResult.get(name));
    }
}
