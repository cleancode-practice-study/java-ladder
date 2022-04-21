package controller;

import model.*;
import view.InputView;
import view.OutputView;

public class LadderGame {
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
        boolean nameLength;
        boolean playerCount;

        do {
            names = inputPlayersNames();
            nameLength = Validator.isValidPlayerNameLength(names);
            playerCount = Validator.isValidPlayersCount(names);

            checkPlayerLengthError(nameLength, playerCount);
        } while (!nameLength || !playerCount);

        return new Players(names);
    }

    private String[] inputPlayersNames() {
        String names = InputView.inputPlayersNames();
        return Convert.splitNames(names);
    }

    private void checkPlayerLengthError(boolean nameLength, boolean playersLength) {
        if (!nameLength) {
            OutputView.printPlayerNameLengthErrorMessage();
            return;
        }

        if (!playersLength) {
            OutputView.printPlayerCountErrorMessage();
        }
    }

    private Prizes createPrizes(Players players) {
        String[] names;
        boolean prizesCount;

        do {
            names = inputPrizes();
            prizesCount = Validator.isValidPrizesCount(names.length, players.getPlayerCount());
            if (!prizesCount) {
                OutputView.printPrizeCountErrorMessage(players.getPlayerCount());
            }
        } while (!prizesCount);

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

        for (Line line : ladder.getLadder())
            OutputView.printLine(line.getPoints());

        OutputView.printPrizes(prizes.getPrizes());
    }

    private GameResult createGameResult(Players players, Ladder ladder, Prizes prizes) {
        GameResultCreator gameResultCreator = new GameResultCreator(players.getPlayers(), ladder.getLadder(), prizes.getPrizes());
        return new GameResult(gameResultCreator.createGameResult());
    }

    private void askAndPrintGameResult(GameResult gameResult) {
        do {
            String name = InputView.inputPeopleResultRequest();
            if (name.equals("all"))
                break;

            printPlayerResult(gameResult, name);
        } while (true);

        OutputView.printAllGameResult(gameResult.getGameResult());
    }
}
