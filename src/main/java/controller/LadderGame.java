package main.java.controller;

import main.java.model.Convert;
import main.java.model.Ladder;
import main.java.model.Players;
import main.java.view.InputView;
import main.java.view.OutputView;

public class LadderGame {
    private static Players createPlayers() {
        String[] names = inputPlayersNames(); // 참여할 사람 이름 입력받기
        return new Players(names);
    }

    private static String[] inputPlayersNames() {
        OutputView.printPlayersNamesInputMessage();
        String names = InputView.inputPlayersNames();
        return Convert.splitNames(names);
    }

    private static Ladder createLadder(int width, int height) {
        return new Ladder(width, height);
    }

    public void play() {
        Players players = createPlayers();
        String prizes = inputPrizes();
        int maxHeight = inputMaxHeight();
        Ladder ladder = createLadder(players.getPlayers().size(), maxHeight);
        OutputView.printPlayersAndLadder(players, ladder);
    }

    private int inputMaxHeight() {
        OutputView.printMaxHeightQuestionMessage();
        return InputView.inputMaxHeight();
    }

    private String inputPrizes() {
        OutputView.printLadderResultsInputMessage();
        return InputView.inputLadderResults();
    }
}
