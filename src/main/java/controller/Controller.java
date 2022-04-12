package controller;

import domain.LadderGame;
import domain.Player;
import domain.Players;
import view.InputView;
import view.OutputView;

public class Controller {

    public void run() {
        Players players = createPlayers();
        for(Player player : players.getPlayers()) {
            System.out.println(player.getName());
        }
    }

    public Players createPlayers() {
        String playerNames;

        do {
            playerNames = InputView.getPlayerNamesInput();
            checkInputNames(playerNames);
        } while (!playerNames.contains(","));

        return LadderGame.getParticipantsByNames(playerNames);
    }

    private void checkInputNames(String names) {
        if (!names.contains(",")) {
            OutputView.printInputNamesErrorMessage();
        }
    }
}


