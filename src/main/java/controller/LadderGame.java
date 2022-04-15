package main.java.controller;

import main.java.model.*;
import main.java.view.InputView;
import main.java.view.OutputView;

public class LadderGame {
    private static Results createResults() {
        String[] names = inputResults(); // 참여할 사람 이름 입력받기
        return new Results(names);
    }

    private static Players createPlayers() {
        String[] names = inputPlayersNames(); // 참여할 사람 이름 입력받기
        boolean check;

        do {
            check = Validator.isPlayerNameLength(names);
            if (!check) {
                OutputView.printPlayerNameLengthErrorMessage();
                names = inputPlayersNames();
            }
        } while (!check);

        return new Players(names);
    }

    private static String[] inputPlayersNames() {
        OutputView.printPlayersNamesInputMessage();
        String names = InputView.inputPlayersNames();
        return Convert.splitNames(names);
    }

    private static String[] inputResults() {
        OutputView.printLadderResultsInputMessage();
        String prizes = InputView.inputLadderResults();
        return Convert.splitNames(prizes);
    }

    private static Ladder createLadder(int width, int height) {
        return new Ladder(width, height);
    }

    private int inputMaxHeight() {
        OutputView.printMaxHeightQuestionMessage();
        return InputView.inputMaxHeight();
    }

    public void play() {
        Players players = createPlayers();
        Results results = createResults();
        int maxHeight = inputMaxHeight();
        Ladder ladder = createLadder(players.getPlayers().size(), maxHeight);
        OutputView.printPlayersAndLadderAndResults(players, ladder, results);
    }
}
