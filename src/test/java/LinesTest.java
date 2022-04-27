import model.Line;
import model.Lines;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    void 정상적인_사다리_생성을_확인하는_경우() {
        //given
        int width = 3;
        int height = 3;
        Lines lines = new Lines(width, height);

        //when
        List<Integer> bridgesCounts = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            int pointCount = calculatePointCount(lines.getLines(), height, i);
            bridgesCounts.add(pointCount);
        }

        //then
        assertThat(bridgesCounts.get(0)).isGreaterThan(0);
        assertThat(bridgesCounts.get(1)).isGreaterThan(0);
        assertThat(bridgesCounts.get(2)).isGreaterThan(0);
    }

    private int calculatePointCount(List<Line> lines, int height, int widthIdx) {
        int pointCount = 0;

        for (int j = 0; j < height; j++) {
            Line line = lines.get(widthIdx);
            List<Boolean> points = line.getLine();
            if (points.get(j))
                pointCount++;
        }

        return pointCount;
    }
}
