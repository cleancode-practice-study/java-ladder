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

    @Test
    void 입력한_플레이어가_한명인_경우(){
        //given
        String[] name = {"halim"};

        //when
        Players players = new Players(name);
        boolean isValid = players.isValidPlayerCount(name);

        //then
        assertThat(isValid).isFalse();
    }

    @Test
    void 입력한_플레이어가_두명_이상인_경우(){
        //given
        String[] names = {"halim", "jinhe"};

        //when
        Players players = new Players(names);
        boolean isValid = players.isValidPlayerCount(names);

        //then
        assertThat(isValid).isTrue();
    }

    @Test
    void 입력한_플레이어_이름의_길이가_6자_이상인_경우(){
        //given
        String[] names = {"halimi", "jinhee"};

        //when
        Players players= new Players(names);
        boolean isValid = players.isValidNameLength(names);

        //then
        assertThat(isValid).isFalse();
    }

    @Test
    void 입력한_플레이어_이름의_길이가_5자_이하인_경우(){
        //given
        String[] names = {"halim", "jinhe"};

        //when
        Players players= new Players(names);
        boolean isValid = players.isValidNameLength(names);

        //then
        assertThat(isValid).isTrue();
    }

}
