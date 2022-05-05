package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputsTest {
    @Test
    public void 실행_결과_생성() {
        Outputs outputs = new Outputs(Arrays.asList(new Output("통과"), new Output("통과"), new Output("꽝")));

        assertThat(outputs.getOutputs().size()).isEqualTo(3);
    }

    @Test
    public void 실행_결과_이름만_받기() {
        Outputs outputs = new Outputs(Arrays.asList(new Output("통과"), new Output("통과"), new Output("꽝")));

        assertThat(outputs.getOutputNames()).contains("통과").contains("통과").contains("꽝");
    }
}
