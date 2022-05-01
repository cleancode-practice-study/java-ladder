package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prizes {
    private final List<String> prizes = new ArrayList<>();

    public Prizes(String[] names) {
        prizes.addAll(Arrays.asList(names));
    }

    public boolean isValidPrizeCount(String[] prize, int playerCount) {
        boolean isValidPrizeCount = Validator.isValidPrizeCount(prize.length, playerCount);

        if (!isValidPrizeCount) {
            System.out.println(playerCount + "개의 실행 결과를 입력 해 주세요.");
        }

        return isValidPrizeCount;
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
