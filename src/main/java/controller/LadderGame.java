package controller;

import model.*;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class LadderGame {
    public static final String ALL = "all";

    public void play() {
        Players players = createPlayers();
        int playerCount = players.getPlayerCount();
        Prizes prizes = createPrizes(playerCount);
        int height = inputHeight();

        Ladder ladder = new Ladder(playerCount, height);

        printLadder(players, ladder, prizes);
        GameResult gameResult = createGameResult(players, ladder, prizes);
        printGameResult(gameResult);
    }

    private Players createPlayers() {
        String[] names;
        Players players;

        do {
            names = inputPlayersNames();
            players = new Players(names);
        } while (!players.isValidNameLength(names) || !players.isValidPlayerCount(names));

        return players;
    }

    private String[] inputPlayersNames() {
        String names = InputView.inputPlayersNames();
        return Convert.splitNames(names);
    }

    private Prizes createPrizes(int playerCount) {
        String[] prize;
        Prizes prizes;

        do {
            prize = inputPrizes();
            prizes = new Prizes(prize);
        } while (!prizes.isValidPrizeCount(prize, playerCount));

        return prizes;
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

    private void printGameResult(GameResult gameResult) {
        do {
            String name = InputView.inputPeopleResultRequest();
            if (name.equals(ALL)) {
                break;
            }

            printPlayerResult(gameResult, name);
        } while (true);

        OutputView.printAllGameResult(gameResult.getGameResult());
    }

    private void printPlayerResult(GameResult gameResult, String name) {
        Map<String, String> results = gameResult.getGameResult();

        if (results.get(name) == null) {
            OutputView.printPlayerErrorMessage();
            return;
        }

        OutputView.printOnePeopleGameResult(gameResult.getGameResult(), name);
    }
}
