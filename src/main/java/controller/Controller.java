package main.java.controller;

import main.java.view.InputView;
import main.java.view.OutputView;

public class Controller {
    public void play(){
        String names = inputPlayersNames();
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

    private String inputPlayersNames(){
        OutputView.printPlayersNamesInputMessage();
        return InputView.inputPlayersNames();
    }
}
