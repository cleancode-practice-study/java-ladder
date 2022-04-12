package view;

import java.util.Scanner;

public class InputView {
    private static final String PLAYER_NAMES_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String GAME_RESULT_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_TO_SEE_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";

    private static final Scanner scanner = new Scanner(System.in);

    public static String getPlayerNamesInput() {
        System.out.println(PLAYER_NAMES_INPUT_MESSAGE);
        return scanner.next();
    }

    public static String getGameResultInput() {
        System.out.println(GAME_RESULT_INPUT_MESSAGE);
        return scanner.next();
    }

    public static String getMaxLadderHeight() {
        System.out.println(MAX_LADDER_HEIGHT_INPUT_MESSAGE);
        return scanner.next();
    }

    public static String getResultToSee() {
        System.out.println(RESULT_TO_SEE_INPUT_MESSAGE);
        return scanner.next();
    }
}
