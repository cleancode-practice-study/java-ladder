import model.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {
    @Test
    void 플레이어_이름의_길이가_기준을_넘은_경우() {
        //given
        String[] names = {"ha", "jinhee", "doo"};

        //when
        boolean result = Validator.isValidPlayerNameLength(names);

        //then
        assertThat(result).isFalse();
    }

    @Test
    void 플레이어_이름의_길이가_기준을_넘지않는_경우() {
        //given
        String[] names = {"ha", "jin", "dowon"};

        //when
        boolean result = Validator.isValidPlayerNameLength(names);

        //then
        assertThat(result).isTrue();
    }
}
