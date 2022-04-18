package main.java.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prizes {
    private final List<String> prizes = new ArrayList<>();

    public Prizes(String[] names) {
        prizes.addAll(Arrays.asList(names));
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
