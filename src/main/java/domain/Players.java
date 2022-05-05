package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<String> getPlayerNames() {
        return players
                .stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public Player findPlayer(int columnIndex) {
        return players.get(columnIndex);
    }
}
