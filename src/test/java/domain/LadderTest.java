package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void 사다리_생성() {
        int playerCount = 3;
        int maxLadderHeight = 3;

        Line lineOne = new Line(Arrays.asList(true, false));
        Line lineTwo = new Line(Arrays.asList(false, true));
        Line lineThree = new Line(Arrays.asList(true, false));

        List<Line> lines = Arrays.asList(lineOne, lineTwo, lineThree);

        Ladder ladder = new Ladder(lines);

        assertThat(ladder.getLines().size()).isEqualTo(maxLadderHeight);
        assertThat(ladder.getLines().get(0).getLineLength()).isEqualTo(playerCount - 1);
    }

    @Test
    public void 랜덤_사다리_생성() {
        int playerCount = 3;
        int maxLadderHeight = 3;
        RootCreator rootCreator = new RandomRootCreator();

        Ladder ladder = new Ladder(RandomLadderCreator.getRandomLadder(playerCount, maxLadderHeight, rootCreator));

        assertThat(ladder.getLines().size()).isEqualTo(maxLadderHeight);
        assertThat(ladder.getLines().get(0).getLineLength()).isEqualTo(playerCount - 1);
    }

    @Test
    public void 잘못된_사다리_생성한_경우() {
        Line lineOne = new Line(Arrays.asList(true, false));
        Line lineTwo = new Line(Arrays.asList(false, false));
        Line lineThree = new Line(Arrays.asList(true, false));

        List<Line> lines = Arrays.asList(lineOne, lineTwo, lineThree);

        Ladder ladder = new Ladder(lines);

        assertThat(ladder.checkLadder()).isFalse();
    }

    @Test
    public void 사다리_타는_로직_검증() {
        Outputs outputs = new Outputs(Arrays.asList(new Output("통과"), new Output("통과"), new Output("꽝")));

        Line lineOne = new Line(Arrays.asList(true, false));
        Line lineTwo = new Line(Arrays.asList(false, true));
        Line lineThree = new Line(Arrays.asList(true, false));

        List<Line> lines = Arrays.asList(lineOne, lineTwo, lineThree);

        Ladder ladder = new Ladder(lines);

        assertThat(ladder.getEachLadderResult(0, outputs).getOutputName()).isEqualTo("꽝");
        assertThat(ladder.getEachLadderResult(1, outputs).getOutputName()).isEqualTo("통과");
        assertThat(ladder.getEachLadderResult(2, outputs).getOutputName()).isEqualTo("통과");
    }
}
