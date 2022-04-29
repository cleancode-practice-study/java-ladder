package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class Controller {

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
            isContainComma = Validator.checkContainComma(playerNames);
            isUnderFiveLetter = Validator.checkUnderFiveLetter(playerNames);

            checkCommaError(isContainComma);
            checkLetterError(isUnderFiveLetter);
        } while (!isContainComma || !isUnderFiveLetter);

        return LadderGame.getParticipantsByNames(playerNames);
    }

    private void checkCommaError(boolean isContainComma) {
        if (!isContainComma) {
            OutputView.printInputNamesErrorMessage();
        }
    }

    private void checkLetterError(boolean isUnderFiveLetter) {
        if (!isUnderFiveLetter) {
            OutputView.printInputNamesLimitErrorMessage();
        }
    }

    public Outputs createOutputs(Players players) {
        String outputNames;
        boolean isMatchedWithPlayerCount;
        boolean isContainComma;

        do {
            outputNames = InputView.getGameResultInput();
            isMatchedWithPlayerCount = Validator.checkIsMatchedWithPlayerCount(outputNames, players);
            isContainComma = Validator.checkContainComma(outputNames);

            checkOutputCount(isMatchedWithPlayerCount);
            checkCommaError(isContainComma);
        } while (!isMatchedWithPlayerCount || !isContainComma);

        return LadderGame.getOutputs(outputNames);
    }

    private void checkOutputCount(boolean isMatchedWithPlayerCount) {
        if (!isMatchedWithPlayerCount) {
            OutputView.printInputResultErrorMessage();
        }
    }

    private Ladder createLadder(int playerCount) {
        int maxLadderHeight = Integer.parseInt(InputView.getMaxLadderHeight());

        return LadderGame.createLadder(playerCount, maxLadderHeight);
    }

    private void showGameResult(GameResult gameResult, Players players) {
        boolean isAllPrint;

        while (true) {
            String printCommand = InputView.printWhichPersonToBeSeen();

            isAllPrint = Validator.checkAllPrintCommand(printCommand);

            printGameResult(isAllPrint, gameResult, players, printCommand);
        }
    }

    private void printGameResult(boolean isAllPrint, GameResult gameResult, Players players, String printCommand) {
        if (isAllPrint) {
            printAllGameResult(gameResult, players);
            return;
        }

        printEachGameResult(gameResult, players, printCommand);

    }

    private void printAllGameResult(GameResult gameResult, Players players) {
        OutputView.printAllGameResult(players, gameResult);
    }

    private void printEachGameResult(GameResult gameResult, Players players, String printCommand) {
        boolean isValidName = Validator.checkPlayerName(printCommand, players);

        if (isValidName) {
            Player player = LadderGame.findPlayer(printCommand, players);
            OutputView.printGameResult(player, gameResult);
            return;
        }

        OutputView.printPlayerAbstractErrorMessage();
    }
}


