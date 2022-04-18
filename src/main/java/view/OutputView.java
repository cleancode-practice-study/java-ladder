package main.java.view;

import main.java.model.*;

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
                if (points.get(i)) System.out.print("| ----- ");
                else System.out.print("|       ");
            } else {
                if (points.get(i)) System.out.print("| ----- |");
                else System.out.print("|       |");
            }
        }
    }

    private static void printLadderResults(List<String> prizes) {
        for (String prize : prizes)
            System.out.printf("%-8s", prize);
        System.out.println("");
    }

    public static void printLadder(Players players, Ladder ladder, Prizes prizes) {
        System.out.println("\n사다리 결과\n");
        printPlayersNames(players.getPlayers());
        System.out.println(" ");
        for (Line line : ladder.getLadder()) {
            System.out.print("  ");
            printLine(line.getPoints());
            System.out.println("");
        }
        printLadderResults(prizes.getPrizes());
    }

    public static void printPlayerNameLengthErrorMessage() {
        System.out.println("이름은 최대 5글자까지 입력할 수 있습니다. 다시 입력 해 주세요.");
    }

    public static void printPlayersCountErrorMessage() {
        System.out.println("두명 이상 입력 해 주세요. \n");
    }

    public static void printResultsCountErrorMessage(Players players) {
        System.out.println(players.getPlayersCount() + "개의 실행 결과를 입력 해 주세요.");
    }

    public static void printGameResultErrorMessage() {
        System.out.println("해당 플레이어는 존재하지 않습니다. \n다시 입력 해 주세요.");
    }

    public static void printPeopleResult(GameResult gameResult, String name) {
        System.out.println("\n실행 결과");
        Map<String, String> results = gameResult.getGameResult();
        System.out.println(results.get(name));
    }

    public static void printAllPeopleResult(GameResult gameResult) {
        Map<String, String> results = gameResult.getGameResult();

        System.out.println("\n실행 결과");
        for (String name : results.keySet())
            System.out.println(name + " : " + results.get(name));
    }
}
