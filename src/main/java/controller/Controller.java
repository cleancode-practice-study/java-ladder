package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final static int PLAYER_NAME_LIMIT = 6;

    public void run() {
        Players players = createPlayers();
        Outputs outputs = createOutputs(players);

        Ladder ladder = createLadder(players.getPlayerCount());

        OutputView.ladderResultMessage(players, ladder, outputs);

        GameResult gameResult = LadderGame.getGameResult(ladder, players, outputs);

        showGameResult(gameResult, players);
    }

    public Players createPlayers() {
        String playerNames;
        boolean isContainComma;
        boolean isUnderFiveLetter;

        do {
            playerNames = InputView.getPlayerNamesInput();
            isContainComma = checkContainComma(playerNames);
            isUnderFiveLetter = checkUnderFiveLetter(playerNames);
        } while (!isContainComma || !isUnderFiveLetter);

        return LadderGame.getParticipantsByNames(playerNames);
    }

    private boolean checkContainComma(String names) {
        if (names.contains(",")) {
            return true;
        }

        OutputView.printInputNamesErrorMessage();
        return false;
    }

    private boolean checkUnderFiveLetter(String names) {
        List<String> playerNames = LadderGame.splitNames(names);

        boolean isUnderFiveLetter = playerNames.stream().allMatch(name -> name.length() < PLAYER_NAME_LIMIT);

        if (isUnderFiveLetter) {
            return true;
        }

        OutputView.printInputNamesLimitErrorMessage();
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

    private Ladder createLadder(int playerCount) {
        int maxLadderHeight = Integer.parseInt(InputView.getMaxLadderHeight());

        return LadderGame.getLadder(playerCount, maxLadderHeight);
    }

    private void showGameResult(GameResult gameResult, Players players) {
        boolean isAllPrint;

        while (true) {
            String printCommand = InputView.printWhichPersonToBeSeen();

            isAllPrint = LadderGame.checkAllPrintCommand(printCommand);

            printGameResult(isAllPrint, gameResult, players, printCommand);
        }
    }

    private void printGameResult(boolean isAllPrint, GameResult gameResult, Players players, String printCommand) {
        if (isAllPrint) {
            printAllGameResult(gameResult, players);
        } else {
            printEachGameResult(gameResult, players, printCommand);
        }
    }

    private void printAllGameResult(GameResult gameResult, Players players) {
        OutputView.printAllGameResult(players, gameResult);
    }

    private void printEachGameResult(GameResult gameResult, Players players, String printCommand) {
        boolean isValidName = LadderGame.checkPlayerName(printCommand, players);

        if (isValidName) {
            Player player = LadderGame.findPlayer(printCommand, players);
            OutputView.printGameResult(player, gameResult);
        }

        if (!isValidName) {
            OutputView.printPlayerAbstractErrorMessage();
        }
    }
}


