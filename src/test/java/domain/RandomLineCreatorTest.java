package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class RandomLineCreatorTest {
    @Test
    public void 랜덤_라인_생성() {
        int playerCount = 3;

        List<Boolean> points = new RandomLineCreator().getLine(playerCount);
        boolean isContinuousRoot = checkRoots(points);

        assertThat(points.size()).isEqualTo(playerCount - 1);
        assertThat(isContinuousRoot).isFalse();
    }

    private boolean checkRoots(List<Boolean> points) {
        for (boolean point : points) {
            if (!point) {
                return false;
            }
        }
        return true;
    }
}
