import model.Prizes;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizesTest {
    @Test
    void 실행_결과_리스트를_생성하는_경우() {
        //given
        String[] names = {"3000", "5000", "꽝", "500"};

        //when
        Prizes prizes = new Prizes(names);
        List<String> prize = prizes.getPrizes();

        //then
        assertThat(prize.get(0)).isEqualTo("3000");
        assertThat(prize.get(1)).isEqualTo("5000");
        assertThat(prize.get(2)).isEqualTo("꽝");
        assertThat(prize.get(3)).isEqualTo("500");

    }
}
