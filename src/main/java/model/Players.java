package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(String[] names) {
        List<Player> players = new ArrayList<>();

        for (String name : names) {
            Player player = new Player(name);
            players.add(player);
        }

        this.players = players;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public int getPlayersCount() {
        return players.size();
    }
}
