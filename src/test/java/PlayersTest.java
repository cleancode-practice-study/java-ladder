import model.Players;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @Test
    void 플레이어_리스트를_생성하는_경우() {
        //given
        String[] names = {"halim", "jinhe", "dowon"};

        //when
        Players players = new Players(names);
        List<String> player = players.getPlayers();
        int count = players.getPlayerCount();

        //then
        assertThat(player.get(0)).isEqualTo("halim");
        assertThat(player.get(1)).isEqualTo("jinhe");
        assertThat(player.get(2)).isEqualTo("dowon");

        assertThat(count).isEqualTo(3);
    }
}
