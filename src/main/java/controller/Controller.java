package main.java.controller;

import main.java.model.Convert;
import main.java.model.Line;
import main.java.model.Players;
import main.java.view.InputView;
import main.java.view.OutputView;

public class Controller {
    public void play(){
        String[] names = inputPlayersNames();
        Players players = new Players(names);
        String results = inputLadderResults();
        int maxHeight = inputLadderMaxHeight();
    }

    private int inputLadderMaxHeight() {
        OutputView.printMaxHeightInputMessage();
        return InputView.inputMaxHeight();
    }

    private String inputLadderResults() {
        OutputView.printLadderResultsInputMessage();
        return InputView.inputLadderResults();
    }

    private String[] inputPlayersNames(){
        OutputView.printPlayersNamesInputMessage();
        String names = InputView.inputPlayersNames();
        return Convert.splitNames(names);
    }
}
