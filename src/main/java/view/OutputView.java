package view;

public class OutputView {
    private static final String INPUT_NAMES_ERROR_MESSAGE = "[ERROR] 쉼표를 포함하여 올바르게 입력해주십시오.";
    private static final String INPUT_RESULT_ERROR_MESSAGE = "[ERROR] 참가자의 수와 동일한 수로 입력해주십시오.";
    private static final String INPUT_NAMES_LIMIT_ERROR_MESSAGE = "[ERROR] 참가자의 이름은 5자 이하로 입력해주십시오.";

    public static void printInputNamesErrorMessage() {
        System.out.println(INPUT_NAMES_ERROR_MESSAGE);
    }

    public static void printInputResultErrorMessage() {
        System.out.println(INPUT_RESULT_ERROR_MESSAGE);
    }

    public static void printInputNamesLimitErrorMessage() {
        System.out.println(INPUT_NAMES_LIMIT_ERROR_MESSAGE);
    }
}
