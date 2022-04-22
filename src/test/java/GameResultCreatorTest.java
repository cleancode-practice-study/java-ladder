import model.GameResultCreator;
import model.Line;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultCreatorTest {
    @Test
    void 게임_결과를_생성하는_경우() {
        //given
        List<String> players = new ArrayList<String>() {
            {
                add("halim");
                add("dowon");
                add("jinhee");
            }

        };

        List<Line> lines = new ArrayList<Line>() {
            {
                add(new Line(players.size() - 1));
                add(new Line(players.size() - 1));
                add(new Line(players.size() - 1));
            }
        };

        List<String> prizes = new ArrayList<String>() {
            {
                add("꽝");
                add("3000");
                add("5000");
            }
        };
        GameResultCreator gameResultCreator = new GameResultCreator(players, lines, prizes);

        //when
        Map<String, String> result = gameResultCreator.getGameResult();

        //then
        assertThat(result.size()).isEqualTo(3);

    }
}
