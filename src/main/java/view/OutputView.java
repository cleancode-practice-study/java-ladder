package main.java.view;

import main.java.model.Ladder;
import main.java.model.Line;
import main.java.model.Players;
import main.java.model.Results;

import java.util.ArrayList;

public class OutputView {
    public static void printPlayersNamesInputMessage() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void printLadderResultsInputMessage() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public static void printMaxHeightQuestionMessage() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printPersonQuestionMessage() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    private static void printLine(ArrayList<Boolean> points) {
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
        for (int i = 0; i < results.getResults().size(); i++) {
            System.out.printf("%-8s", results.getResults().get(i).getPrize());
        }
    }

    public static void printPlayersAndLadderAndResults(Players players, Ladder ladder, Results results) {
        System.out.println("사다리 결과");
        printPlayersNames(players);
        System.out.println(" ");
        for (Line line : ladder.getLadder()) {
            System.out.print("  ");
            OutputView.printLine(line.getPoints());
            System.out.println("");
        }
        printLadderResults(results);
    }

    public static void printPlayerNameLengthErrorMessage() {
        System.out.println("이름은 최대 5글자까지 입력할 수 있습니다. 다시 입력 해 주세요. \n");
    }

    public static void printPlayersLengthErrorMessage() {
        System.out.println("두명 이상 입력 해 주세요. \n");
    }
}
