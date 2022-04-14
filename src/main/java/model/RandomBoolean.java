package main.java.model;

import java.util.Arrays;

public enum RandomBoolean {

    TRUE(0, true),
    FALSE(1, false);

    private final int idx;
    private final boolean bool;

    RandomBoolean(int idx, boolean bool){
        this.idx = idx;
        this.bool = bool;
    }

    public static RandomBoolean getRandomBoolean(int idx){
        return Arrays.stream(RandomBoolean.values())
                .filter(r -> r.idx == idx)
                .findAny()
                .orElse(null);
    }

    public boolean getBoolean(){
        return this.bool;
    }
}
