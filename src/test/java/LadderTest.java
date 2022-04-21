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
        int height = 5;
        Ladder ladder = new Ladder(playerCount - 1, height);

        //when
        List<Line> ladderLine = ladder.getLadder();

        //then
        assertThat(ladderLine.size()).isEqualTo(height);
        assertThat(ladderLine.get(0).getPoints().size()).isEqualTo(playerCount - 1);
    }
}
