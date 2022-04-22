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

    @Test
    void 연속된_TRUE가_존재하지_않도록_라인이_생성되는지_확인하는_경우() {
        //given
        int width = 3;

        //when
        Line line = new Line(width);
        int trueIdx = 0;
        for (int i = 0; i < line.getLine().size() - 1; i++) {
            if (line.getLine().get(i)) {
                trueIdx = i;
                break;
            }
        }

        //then
        assertThat(line.getLine().get(trueIdx + 1)).isFalse();
    }
}
