package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomRootCreatorTest {
    @Test
    public void 랜덤_사다리_루트_생성() {
        boolean isRoot = RandomRootCreator.getRandomRoot();

        assertThat(isRoot).isNotNull();
    }
}
