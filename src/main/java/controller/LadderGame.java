package main.java.controller;

import main.java.model.*;
import main.java.view.InputView;
import main.java.view.OutputView;

public class LadderGame {
    private static Results createResults(Players players) {
        String[] names;
        boolean resultsLength;

        do {
            names = inputResults();
            resultsLength = Validator.isValidResultsLength(names.length, players.getPlayers().size());
            if (!resultsLength) {
                OutputView.printResultsLengthErrorMessage(players);
                names = inputResults();
            }
        } while (!resultsLength);

        return new Results(names);
    }

    private static Players createPlayers() {
        String[] names;
        boolean nameLength;
        boolean playersLength;

        do {
            names = inputPlayersNames();
            nameLength = Validator.isValidPlayerNameLength(names);
            playersLength = Validator.isValidPlayersLength(names);

            checkPlayerLengthError(nameLength, playersLength);
        } while (!nameLength || !playersLength);

        return new Players(names);
    }

    private static void checkPlayerLengthError(boolean nameLength, boolean playersLength) {
        if (!nameLength || !playersLength) {
            if (!nameLength) {
                OutputView.printPlayerNameLengthErrorMessage();
                return;
            }
            OutputView.printPlayersLengthErrorMessage();

        }
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
        Results results = createResults(players);
        int maxHeight = inputMaxHeight();
        Ladder ladder = createLadder(players.getPlayers().size(), maxHeight);
        OutputView.printPlayersAndLadderAndResults(players, ladder, results);
    }
}
