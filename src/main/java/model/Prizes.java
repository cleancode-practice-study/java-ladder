package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
    private final List<String> prizes = new ArrayList<>();

    public Prizes(String[] names) {
        for (String prize : names) {
            prizes.add(prize);
        }
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
