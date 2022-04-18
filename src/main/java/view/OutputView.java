package main.java.view;

import main.java.model.*;

import java.util.List;

public class OutputView {
    private static void printLine(List<Boolean> points) {
        for (int i = 0; i < points.size(); i++) {
            if (i != points.size() - 1) {
                if (points.get(i))
                    System.out.print("| ----- ");
                else
                    System.out.print("|       ");
            } else {
                if (points.get(i))
                    System.out.print("| ----- |");
                else
                    System.out.print("|       |");
            }
        }
    }

    private static void printPlayersNames(Players players) {
        for (int i = 0; i < players.getPlayers().size(); i++)
            System.out.printf("%-8s", players.getPlayers().get(i).getName());
    }

    private static void printLadderResults(Results results) {
        for (int i = 0; i < results.getResults().size(); i++)
            System.out.printf("%-8s", results.getResults().get(i).getPrize());
        System.out.println("");

    }

    public static void printLadder(Players players, Ladder ladder, Results results) {
        System.out.println("사다리 결과");
        printPlayersNames(players);
        System.out.println(" ");
        for (Line line : ladder.getLadder()) {
            System.out.print("  ");
            OutputView.printLine(line.getPoints());
            System.out.println("");
        }
        printLadderResults(results);
        System.out.println("");
    }

    public static void printPlayerNameLengthErrorMessage() {
        System.out.println("이름은 최대 5글자까지 입력할 수 있습니다. 다시 입력 해 주세요. \n");
    }

    public static void printPlayersLengthErrorMessage() {
        System.out.println("두명 이상 입력 해 주세요. \n");
    }

    public static void printResultsLengthErrorMessage(Players players) {
        System.out.println(players.getPlayers().size() + "개의 실행 결과를 입력 해 주세요. \n");
    }

    public static void printPeopleResult(String name) {
        System.out.println("\n실행 결과");
        System.out.println(name + "\n");
    }

    public static void printAllPeopleResult(GameResult gameResult) {
        System.out.println("\n실행 결과");
        for (String key : gameResult.getGameResult().keySet())
            System.out.println(key + " : " + gameResult.getGameResult().get(key));
    }
}
