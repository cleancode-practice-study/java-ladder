package main.java.controller;

import main.java.model.Convert;
import main.java.model.Ladder;
import main.java.model.Line;
import main.java.model.Players;
import main.java.view.InputView;
import main.java.view.OutputView;

public class LadderGame {
    public void play() {
        Players players = createPlayers();
        String results = inputLadderResults();
        int maxHeight = inputLadderMaxHeight();
        Ladder ladder = new Ladder(players.getPlayers().size(), maxHeight);
        OutputView.printLadder(ladder);
    }

    private static Players createPlayers() {
        String[] names = inputPlayersNames();
        return new Players(names);
    }

    private static String[] inputPlayersNames() {
        OutputView.printPlayersNamesInputMessage();
        String names = InputView.inputPlayersNames();
        return Convert.splitNames(names);
    }

    private int inputLadderMaxHeight() {
        OutputView.printMaxHeightInputMessage();
        return InputView.inputMaxHeight();
    }

    private String inputLadderResults() {
        OutputView.printLadderResultsInputMessage();
        return InputView.inputLadderResults();
    }
}
