package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    public static final String INPUT_POSITIVE_NUMBER_ERROR_MESSAGE = "양수를 입력 해 주세요.";
    static Scanner scanner = new Scanner(System.in);

    public static String inputPlayersNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.next();
    }

    public static String inputPrizes() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.next();
    }

    public static int inputHeight() {
        int height;

        while (true) {
            try {
                System.out.println("\n최대 사다리 높이는 몇 개인가요?");
                height = scanner.nextInt();

                if (height > 0) {
                    break;
                }else{
                    System.out.println(INPUT_POSITIVE_NUMBER_ERROR_MESSAGE);
                }
            } catch (InputMismatchException e) {
                System.out.println(INPUT_POSITIVE_NUMBER_ERROR_MESSAGE);
                scanner.nextLine();
            }
        }

        return height;
    }

    public static String inputPeopleResultRequest() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}
