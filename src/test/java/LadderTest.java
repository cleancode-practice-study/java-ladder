import model.Ladder;
import model.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void 사다리를_생성하는_경우() {
        //given
        int playerCount = 5;
        int width = playerCount - 1;
        int height = 5;
        Ladder ladder = new Ladder(playerCount, height);

        //when
        List<Line> ladderLine = ladder.getLadder();

        //then
        assertThat(ladderLine.size()).isEqualTo(height);
        assertThat(ladderLine.get(0).getLine().size()).isEqualTo(width);
    }
}
