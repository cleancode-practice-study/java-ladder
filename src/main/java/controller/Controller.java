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
        // all -> 전체 게임 결과 출력
        // name -> 각 한 명당 게임 결과 출력
            // name 잘못 됐다면 다시 입력 받도록 함
        // 위 과정을 반복

        boolean isAllPrint;

        while (true) {
            String printCommand = InputView.printWhichPersonToBeSeen();
            isAllPrint = LadderGame.checkAllPrintCommand(printCommand);

            // isAllPrint : true -> all 출력하고 끝내기
            printGameResult(isAllPrint, gameResult, players, printCommand);
            // isAllPrint : false -> 한 명 씩 출력
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

//    private void showGameResults(GameResult gameResult, Players players) {
//        boolean loop = true;
//        boolean isAllPrintResult;
//        boolean isValidName;
//
//        do {
//            String printCommand = InputView.printWhichPersonToBeSeen();
//
//            isAllPrintResult = LadderGame.checkAllPrintCommand(printCommand);
//            isValidName = LadderGame.checkPlayerName(printCommand, players);
//
//            printGameResult(printCommand, isAllPrintResult, players, gameResult);
//        } while (loop);
//    }
//
//    private void printGameResult(String printCommand, boolean isAllPrintResult, Players players, GameResult gameResult) {
//        boolean isValidName;
//
//        if (isAllPrintResult) {
//            OutputView.printAllGameResult(players, gameResult);
//            return;
//        }
//
//        Player player = LadderGame.findPlayer(printCommand, players);
//
//        isValidName = checkPlayerState(player);
//
//
//    }
//
//    private boolean checkPlayerState(Player player) {
//        if (player == null) {
//            OutputView.printPlayerAbstractErrorMessage();
//            return false;
//        }
//        return true;
//    }
}


