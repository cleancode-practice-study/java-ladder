import model.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 라인을_생성하는_경우() {
        //given
        int width = 3;

        //when
        Line line = new Line(width);

        //then
        assertThat(line.getLine().size()).isEqualTo(width);
    }
}
