package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class RandomLineCreatorTest {
    @Test
    public void 루트가_있는_라인_생성() {
        int playerCount = 3;
        RootCreator rootCreator = new MovableRootCreator();

        List<Boolean> points = new RandomLineCreator().getLine(playerCount, rootCreator);
        boolean isContinuousRoot = checkRoots(points);

        assertThat(points.size()).isEqualTo(playerCount - 1);
        assertThat(points.contains(true)).isTrue();
        assertThat(isContinuousRoot).isFalse();
    }

    @Test
    public void 루트가_없는_라인_생성() {
        int playerCount = 3;
        RootCreator rootCreator = new NonMovableRootCreator();

        List<Boolean> points = new RandomLineCreator().getLine(playerCount, rootCreator);
        boolean isContinuousRoot = checkRoots(points);

        assertThat(points.size()).isEqualTo(playerCount - 1);
        assertThat(points.contains(true)).isFalse();
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
