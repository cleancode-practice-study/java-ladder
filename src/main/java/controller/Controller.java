package controller;

import domain.LadderGame;
import domain.Player;
import domain.Players;
import view.InputView;

public class Controller {

    public void run() {
        Players players = createPlayers();
        for(Player player : players.getPlayers()) {
            System.out.println(player.getName());
        }
    }

    public Players createPlayers() {
        String playerNames;

        playerNames = InputView.getPlayerNamesInput();

        return LadderGame.getParticipantsByNames(playerNames);
    }
}


