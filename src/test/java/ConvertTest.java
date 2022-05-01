import model.Convert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertTest {
    @Test
    void 쉼표_기준으로_자르는_경우() {
        //given
        String name = "halim,jinhee,dowon";

        //when
        String[] names = Convert.splitNames(name);

        //then
        assertThat(names[0]).isEqualTo("halim");
        assertThat(names[1]).isEqualTo("jinhee");
        assertThat(names[2]).isEqualTo("dowon");
    }
}
