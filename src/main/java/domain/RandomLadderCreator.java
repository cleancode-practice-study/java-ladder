package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RandomLadderCreator {
    public static List<Line> getRandomLadder(int playerCount, int maxLadderHeight) {
        List<Line> lines = new ArrayList<>();

        IntStream.range(0, maxLadderHeight)
                .forEach(i -> lines.add(new Line(new RandomLineCreator().getLine(playerCount))));

        return lines;
    }
}
