package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLadderCreatorTest {
    @Test
    public void 랜덤_사다리_생성() {
        int playerCount = 3;
        int maxLadderHeight = 3;

        List<Line> lines = RandomLadderCreator.getRandomLadder(playerCount, maxLadderHeight);

        assertThat(lines.size()).isEqualTo(maxLadderHeight);
        assertThat(lines.get(0).getLineLength()).isEqualTo(playerCount - 1);
    }
}
