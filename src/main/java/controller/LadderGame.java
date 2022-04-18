package main.java.controller;

import main.java.model.*;
import main.java.view.InputView;
import main.java.view.OutputView;

public class LadderGame {
    public void play() {
        Players players = createPlayers();
        Results results = createResults(players);
        int height = inputHeight();
        Ladder ladder = createLadder(players.getPlayerCount(), height);
        OutputView.printLadder(players, ladder, results);

        GameResult gameResult = getGameResult(players, ladder, results);

        String name;
        do {
            name = InputView.inputPeopleResultRequest();
            if (name.equals("all"))
                break;

            OutputView.printPeopleResult(gameResult.getGameResult().get(name));
        } while (!name.equals("all"));

        OutputView.printAllPeopleResult(gameResult);
    }

    private Players createPlayers() {
        String[] names;
        boolean nameLength;
        boolean playerCount;

        do {
            names = inputPlayersNames();
            nameLength = Validator.isValidPlayerNameLength(names);
            playerCount = Validator.isValidPlayerCount(names);

            checkPlayerLengthError(nameLength, playerCount);
        } while (!nameLength || !playerCount);

        return new Players(names);
    }

    private void checkPlayerLengthError(boolean nameLength, boolean playersLength) {
        if (!nameLength || !playersLength) {
            if (!nameLength) {
                OutputView.printPlayerNameLengthErrorMessage();
                return;
            }

            OutputView.printPlayersLengthErrorMessage();
        }
    }

    private Results createResults(Players players) {
        String[] names;
        boolean resultsLength;

        do {
            names = inputResults();
            resultsLength = Validator.isValidResultCount(names.length, players.getPlayerCount());
            if (!resultsLength)
                OutputView.printResultsLengthErrorMessage(players);
        } while (!resultsLength);

        return new Results(names);
    }

    private Ladder createLadder(int width, int height) {
        return new Ladder(width, height);
    }

    private GameResult getGameResult(Players players, Ladder ladder, Results results) {
        GameResultCreator gameResultCreator = new GameResultCreator(players, ladder, results);
        return new GameResult(gameResultCreator);
    }

    private String[] inputPlayersNames() {
        String names = InputView.inputPlayersNames();
        return Convert.splitNames(names);
    }

    private String[] inputResults() {
        String prizes = InputView.inputLadderResults();
        return Convert.splitNames(prizes);
    }

    private int inputHeight() {
        return InputView.inputHeight();
    }
}
