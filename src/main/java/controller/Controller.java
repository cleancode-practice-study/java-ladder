package controller;

import domain.LadderGame;
import domain.Player;
import view.InputView;

import java.util.List;

public class Controller {

    public void run() {
        List<Player> players = createPlayers();
        for(Player player : players) {
            System.out.println(player.getName());
        }
    }

    public List<Player> createPlayers() {
        String playerNames;

        playerNames = InputView.getPlayerNamesInput();

        return LadderGame.getParticipantsByNames(playerNames);
    }
}


