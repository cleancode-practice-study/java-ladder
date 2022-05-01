import model.GameResult;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @Test
    void 게임_결과_객체를_생성하는_경우(){
        //given
        Map<String, String> gameResult = new HashMap<String, String>(){
            {
                put("halim", "1000");
                put("dowon", "2000");
                put("jinhe", "3000");
            }
        };

        //when
        GameResult result = new GameResult(gameResult);

        //then
        assertThat(result.getGameResult().get("halim")).isEqualTo("1000");
        assertThat(result.getGameResult().get("dowon")).isEqualTo("2000");
        assertThat(result.getGameResult().get("jinhe")).isEqualTo("3000");
    }
}
