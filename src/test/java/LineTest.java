import model.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 라인을_생성하는_경우() {
        //given
        int width = 3;

        //when
        Line line = new Line(width);
        List<Boolean> points = line.getLine();

        //then
        assertThat(points.size()).isEqualTo(width);
    }

    @Test
    void 연속된_TRUE가_존재하지_않도록_라인이_생성되는지_확인하는_경우() {
        //given
        int width = 3;
        int trueIdx = 0;

        //when
        Line line = new Line(width);
        List<Boolean> points = line.getLine();
        int length = points.size() - 1;

        for (int i = 0; i < length; i++) {
            boolean point = points.get(i);

            if (point) {
                trueIdx = i;
                break;
            }
        }

        //then
        assertThat(points.get(trueIdx + 1)).isFalse();
    }
}
