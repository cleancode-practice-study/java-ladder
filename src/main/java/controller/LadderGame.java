package controller;

import model.*;
import view.InputView;
import view.OutputView;

public class LadderGame {
    public static final String ALL = "all";

    public void play() {
        Players players = createPlayers();
        Prizes prizes = createPrizes(players);
        int playerCount = players.getPlayerCount();
        int height = inputHeight();
        Ladder ladder = new Ladder(playerCount, height);

        printLadder(players, ladder, prizes);
        GameResult gameResult = createGameResult(players, ladder, prizes);
        askAndPrintGameResult(gameResult);
    }

    private void printPlayerResult(GameResult gameResult, String name) {
        if (gameResult.getGameResult().get(name) == null) {
            OutputView.printPlayerErrorMessage();
            return;
        }

        OutputView.printOnePeopleGameResult(gameResult.getGameResult(), name);
    }

    private Players createPlayers() {
        String[] names;
        boolean isValidNameLength, isValidPlayerCount;

        do {
            names = inputPlayersNames();
            isValidNameLength = Validator.isValidPlayerNameLength(names);
            isValidPlayerCount = Validator.isValidPlayersCount(names);

            checkPlayerLengthError(isValidNameLength, isValidPlayerCount);
        } while (!isValidNameLength || !isValidPlayerCount);

        return new Players(names);
    }

    private String[] inputPlayersNames() {
        String names = InputView.inputPlayersNames();
        return Convert.splitNames(names);
    }

    private void checkPlayerLengthError(boolean isValidNameLength, boolean isValidPlayerCount) {
        if (!isValidNameLength) {
            OutputView.printPlayerNameLengthErrorMessage();
            return;
        }

        if (!isValidPlayerCount) {
            OutputView.printPlayerCountErrorMessage();
        }
    }

    private Prizes createPrizes(Players players) {
        String[] names;
        boolean isValidPrizesCount;

        do {
            names = inputPrizes();
            int playersCount = players.getPlayerCount();
            isValidPrizesCount = Validator.isValidPrizesCount(names.length, playersCount);
            if (!isValidPrizesCount) {
                OutputView.printPrizeCountErrorMessage(playersCount);
            }
        } while (!isValidPrizesCount);

        return new Prizes(names);
    }

    private String[] inputPrizes() {
        String prizes = InputView.inputPrizes();
        return Convert.splitNames(prizes);
    }

    private int inputHeight() {
        return InputView.inputHeight();
    }

    private void printLadder(Players players, Ladder ladder, Prizes prizes) {
        OutputView.printPlayersNames(players.getPlayers());

        for (Line line : ladder.getLadder()) {
            OutputView.printLine(line.getLine());
        }

        OutputView.printPrizes(prizes.getPrizes());
    }

    private GameResult createGameResult(Players players, Ladder ladder, Prizes prizes) {
        GameResultCreator gameResultCreator = new GameResultCreator(players.getPlayers(), ladder.getLadder(), prizes.getPrizes());
        return new GameResult(gameResultCreator.getGameResult());
    }

    private void askAndPrintGameResult(GameResult gameResult) {
        do {
            String name = InputView.inputPeopleResultRequest();
            if (name.equals(ALL)) {
                break;
            }

            printPlayerResult(gameResult, name);
        } while (true);

        OutputView.printAllGameResult(gameResult.getGameResult());
    }
}
