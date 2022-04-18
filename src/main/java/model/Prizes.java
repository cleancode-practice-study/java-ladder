package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
    private final List<Prize> prizes = new ArrayList<>();

    public Prizes(String[] names) {
        for (String name : names) {
            Prize prize = new Prize(name);
            prizes.add(prize);
        }
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
