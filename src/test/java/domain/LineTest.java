package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 가로_라인_생성() {
        int playerCount = 3;

        List<Boolean> points = Arrays.asList(true, false);
        Line line = new Line(points);

        assertThat(line.getLineLength()).isEqualTo(playerCount - 1);
    }
}
