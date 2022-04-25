package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void 입력_값에_콤마가_있는_경우() {
        assertThat(LadderGame.checkContainComma("진희,하림,도원")).isTrue();
    }

    @Test
    public void 입력_값에_콤마가_없는_경우() {
        assertThat(LadderGame.checkContainComma("진희.하림/도원")).isFalse();
    }

    @Test
    public void 이름_길이_5가_넘지_않는_경우() {
        assertThat(LadderGame.checkUnderFiveLetter("jinhe,halim,dowon")).isTrue();
    }

    @Test
    public void 이름_길이_5가_넘는_경우() {
        assertThat(LadderGame.checkUnderFiveLetter("jinhee,halim,dowonnn")).isFalse();
    }

    @Test
    public void 참가자_수와_실행_결과_수가_맞는_경우() {
        String outputNames = "통과,통과,꽝";

        Players players = new Players(Arrays.asList(new Player("진희"), new Player("하림"), new Player("도원")));

        assertThat(LadderGame.checkIsMatchedWithPlayerCount(outputNames, players)).isTrue();
    }

    @Test
    public void 참가자_수와_실행_결과_수가_맞지_않는_경우() {
        String outputNames = "통과,통과,꽝,꽝";

        Players players = new Players(Arrays.asList(new Player("진희"), new Player("하림"), new Player("도원")));

        assertThat(LadderGame.checkIsMatchedWithPlayerCount(outputNames, players)).isFalse();
    }

    @Test
    public void 입력_받은_이름으로_참가자_객체_생성() {
        String playerNames = "진희,하림,도원";

        Players players = LadderGame.getParticipantsByNames(playerNames);

        assertThat(players.getPlayerCount()).isEqualTo(3);
        assertThat(players.getPlayers().get(0).getName()).isEqualTo("진희");
    }

    @Test
    public void 입력_받은_실행_결과로_실행_결과_객체_생성() {
        String outputNames = "통과,통과,꽝";

        Outputs outputs = LadderGame.getOutputs(outputNames);

        assertThat(outputs.getOutputs().size()).isEqualTo(3);
        assertThat(outputs.getOutputs().get(0).getOutputName()).isEqualTo("통과");
    }

    @Test
    public void 게임_결과_계산() {
        List<Line> lines = Arrays.asList(new Line(Arrays.asList(true, false)),
                new Line(Arrays.asList(false, true)), new Line(Arrays.asList(true, false)));

        Ladder ladder = new Ladder(lines);

        Players players = new Players(Arrays.asList(new Player("진희"), new Player("하림"), new Player("도원")));

        Outputs outputs = new Outputs(Arrays.asList(new Output("통과"), new Output("통과"), new Output("꽝")));

        GameResult gameResult = LadderGame.getGameResult(ladder, players, outputs);

        assertThat(gameResult.getResult(players.getPlayers().get(0))).isEqualTo("꽝");
        assertThat(gameResult.getResult(players.getPlayers().get(1))).isEqualTo("통과");
        assertThat(gameResult.getResult(players.getPlayers().get(2))).isEqualTo("통과");
    }

    @Test
    public void 정상_사다리_생성() {
        int playerCount = 3;
        int maxLadderHeight = 3;

        Ladder ladder = LadderGame.createLadder(playerCount, maxLadderHeight);

        assertThat(ladder.checkLadder()).isTrue();
    }

    @Test
    public void 결과_보고자_하는_참가자_찾는_경우() {
        String inputPlayerName = "진희";

        Players players = new Players(Arrays.asList(new Player("진희"), new Player("하림"), new Player("도원")));

        assertThat(LadderGame.findPlayer(inputPlayerName, players)).isNotNull();
        assertThat(LadderGame.findPlayer(inputPlayerName, players)).isEqualTo(players.getPlayers().get(0));
    }

    @Test
    public void 결과_보고자_하는_참가자_찾을_수_없는_경우() {
        String inputPlayerName = "진휘";

        Players players = new Players(Arrays.asList(new Player("진희"), new Player("하림"), new Player("도원")));

        assertThat(LadderGame.findPlayer(inputPlayerName, players)).isNull();
    }

    @Test
    public void 결과_보고자_하는_참가자_이름_올바르게_입력했을_경우() {
        String inputPlayerName = "진희";

        Players players = new Players(Arrays.asList(new Player("진희"), new Player("하림"), new Player("도원")));

        assertThat(LadderGame.checkPlayerName(inputPlayerName, players)).isTrue();
    }

    @Test
    public void 결과_보고자_하는_참가자_이름_잘못_입력했을_경우() {
        String inputPlayerName = "진휘";

        Players players = new Players(Arrays.asList(new Player("진희"), new Player("하림"), new Player("도원")));

        assertThat(LadderGame.checkPlayerName(inputPlayerName, players)).isFalse();
    }
}
