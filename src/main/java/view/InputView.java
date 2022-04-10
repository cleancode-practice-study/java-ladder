package main.java.view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String inputPlayersNames() {
        return scanner.next();
    }
}
