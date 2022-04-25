package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @Test
    public void 게임_결과_생성() {
        List<Line> lines = Arrays.asList(new Line(Arrays.asList(true, false)),
                new Line(Arrays.asList(false, true)), new Line(Arrays.asList(true, false)));

        Ladder ladder = new Ladder(lines);

        Players players = new Players(Arrays.asList(new Player("진희"), new Player("하림"), new Player("도원")));

        Outputs outputs = new Outputs(Arrays.asList(new Output("통과"), new Output("통과"), new Output("꽝")));

        GameResult gameResult = LadderGame.getGameResult(ladder, players, outputs);

        assertThat(gameResult.getResult(players.getPlayers().get(0))).isEqualTo("꽝");
        assertThat(gameResult.getResult(players.getPlayers().get(1))).isEqualTo("통과");
        assertThat(gameResult.getResult(players.getPlayers().get(2))).isEqualTo("통과");
    }
}
