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

    public boolean isValidPlayerCount(String[] names) {
        boolean isValidPlayerCount = Validator.isValidPlayerCount(names);

        if (!isValidPlayerCount) {
            System.out.println("두명 이상 입력 해 주세요. \n");
        }

        return isValidPlayerCount;
    }

    public boolean isValidNameLength(String[] names) {
        boolean isValidNameLength = Validator.isValidPlayerNameLength(names);

        if (!isValidNameLength) {
            System.out.println("이름은 최대 5글자까지 입력할 수 있습니다. 다시 입력 해 주세요. \n");
        }

        return isValidNameLength;
    }

    public List<String> getPlayers() {
        return this.players;
    }

    public int getPlayerCount() {
        return players.size();
    }
}
