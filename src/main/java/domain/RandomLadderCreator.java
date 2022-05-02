package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLadderCreator {
    public static List<Line> getRandomLadder(int playerCount, int maxLadderHeight, RootCreator rootCreator) {
        return IntStream.range(0, maxLadderHeight)
                .mapToObj(line -> new Line(new RandomLineCreator().getLine(playerCount, rootCreator)))
                .collect(Collectors.toList());
    }
}
