package com.javarush.islandsimulation.management;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    static int promptForInt(String message) {
        int userInput;

        while (true) {
            try {
                System.out.println(message);
                userInput = SCANNER.nextInt();

                if (isValidInput(userInput)) {
                    break;
                } else {
                    printErrorMessage();
                }
            } catch (InputMismatchException e) {
                printErrorMessage();
                SCANNER.nextLine();
            }
        }
        return userInput;
    }

    private static boolean isValidInput(int userInput) {
        return userInput >= MIN_VALUE && userInput <= MAX_VALUE;
    }

    private static void printErrorMessage() {
        System.out.println("Помилка. Введіть ціле число від " + MIN_VALUE + " до " + MAX_VALUE + ".");
    }
}
