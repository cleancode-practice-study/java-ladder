package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class Controller {

    public void run() {
        Players players = createPlayers();
        Outputs outputs = createOutputs(players);

        for (Player player : players.getPlayers()) {
            System.out.println(player.getName());
        }

        for (Output output : outputs.getOutputs()) {
            System.out.println(output.getOutputName());
        }
    }

    public Players createPlayers() {
        String playerNames;
        boolean isContainComma;

        do {
            playerNames = InputView.getPlayerNamesInput();
            isContainComma = checkContainComma(playerNames);
        } while (!isContainComma);

        return LadderGame.getParticipantsByNames(playerNames);
    }

    private boolean checkContainComma(String names) {
        if (names.contains(",")) {
            return true;
        }

        OutputView.printInputNamesErrorMessage();
        return false;
    }

    public Outputs createOutputs(Players players) {
        String outputNames;
        boolean isMatchedWithPlayerCount;
        boolean isContainComma;

        do {
            outputNames = InputView.getGameResultInput();
            isMatchedWithPlayerCount = checkIsMatchedWithPlayerCount(outputNames, players);
            isContainComma = checkContainComma(outputNames);
        } while (!isMatchedWithPlayerCount || !isContainComma);

        return LadderGame.getOutputs(outputNames);
    }

    private boolean checkIsMatchedWithPlayerCount(String outputNames, Players players) {
        String[] outputs = outputNames.split(",");

        if (outputs.length == players.getPlayerCount()) {
            return true;
        }

        OutputView.printInputResultErrorMessage();
        return false;
    }
}


