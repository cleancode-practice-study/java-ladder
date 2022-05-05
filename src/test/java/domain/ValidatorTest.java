package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

public class ValidatorTest {
    @Test
    public void 입력_값에_콤마가_있는_경우() {
        assertThat(Validator.checkContainComma("진희,하림,도원")).isTrue();
    }

    @Test
    public void 입력_값에_콤마가_없는_경우() {
        assertThat(Validator.checkContainComma("진희.하림/도원")).isFalse();
    }

    @Test
    public void 이름_길이_5가_넘지_않는_경우() {
        assertThat(Validator.checkUnderFiveLetter("jinhe,halim,dowon")).isTrue();
    }

    @Test
    public void 이름_길이_5가_넘는_경우() {
        assertThat(Validator.checkUnderFiveLetter("jinhee,halim,dowonnn")).isFalse();
    }

    @Test
    public void 참가자_수와_실행_결과_수가_맞는_경우() {
        String outputNames = "통과,통과,꽝";

        Players players = new Players(Arrays.asList(new Player("진희"), new Player("하림"), new Player("도원")));

        assertThat(Validator.checkIsMatchedWithPlayerCount(outputNames, players)).isTrue();
    }

    @Test
    public void 참가자_수와_실행_결과_수가_맞지_않는_경우() {
        String outputNames = "통과,통과,꽝,꽝";

        Players players = new Players(Arrays.asList(new Player("진희"), new Player("하림"), new Player("도원")));

        assertThat(Validator.checkIsMatchedWithPlayerCount(outputNames, players)).isFalse();
    }

    @Test
    public void 결과_보고자_하는_참가자_이름_올바르게_입력했을_경우() {
        String inputPlayerName = "진희";

        Players players = new Players(Arrays.asList(new Player("진희"), new Player("하림"), new Player("도원")));

        assertThat(Validator.checkPlayerName(inputPlayerName, players)).isTrue();
    }

    @Test
    public void 결과_보고자_하는_참가자_이름_잘못_입력했을_경우() {
        String inputPlayerName = "진휘";

        Players players = new Players(Arrays.asList(new Player("진희"), new Player("하림"), new Player("도원")));

        assertThat(Validator.checkPlayerName(inputPlayerName, players)).isFalse();
    }
}
