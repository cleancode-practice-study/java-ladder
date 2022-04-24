package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 가로_라인_생성() {
        int playerCount = 3;

        Line line = new Line(playerCount);

        assertThat(line.getLineLength()).isEqualTo(playerCount - 1);
    }
}
