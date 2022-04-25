package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @Test
    public void 참가자_생성() {
        Players players = new Players(Arrays.asList(new Player("진희"), new Player("하림"), new Player("도원")));

        assertThat(players.getPlayerCount()).isEqualTo(3);
    }

    @Test
    public void 참가자_이름만_받기() {
        Players players = new Players(Arrays.asList(new Player("진희"), new Player("하림"), new Player("도원")));

        assertThat(players.getPlayerNames()).contains("진희").contains("하림").contains("도원");
    }

}
