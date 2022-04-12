package view;

public class OutputView {
    private static final String INPUT_NAMES_ERROR_MESSAGE = "[ERROR] 쉼표를 포함하여 올바르게 입력해주십시오.";

    public static void printInputNamesErrorMessage() {
        System.out.println(INPUT_NAMES_ERROR_MESSAGE);
    }
}
