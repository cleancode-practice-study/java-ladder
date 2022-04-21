package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {
    private final List<String> players;

    public Players(String[] names) {
        List<String> player = new ArrayList<>();
        Collections.addAll(player, names);

        this.players = player;
    }

    public List<String> getPlayers() {
        return this.players;
    }

    public int getPlayerCount() {
        return players.size();
    }
}
