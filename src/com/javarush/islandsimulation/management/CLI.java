package com.javarush.islandsimulation.management;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;
    private static final int optionFirst = 1;
    private static final int optionSecond = 2;

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

    public static int promptForOption() {
        int userInput;

        while (true) {
            try {
                System.out.println("____________________________________________________________________________________________________________________");
                System.out.println("Введiть " + optionFirst + ", якщо Ви хочете запустити симуляцiю i перевiрити скiльки днiв проживе популяцiя тварин на островi ");
                System.out.println("____________________________________________________________________________________________________________________");
                System.out.println("Введiть " + optionSecond + ", якщо Ви хочете запустити симуляцiю на фiксовану кiлькiсть днiв i отримати статистику за вказаний перiод ");
                System.out.println("____________________________________________________________________________________________________________________");

                userInput = SCANNER.nextInt();

                if (userInput == optionFirst || userInput == optionSecond) {
                    break;
                } else {
                    printErrorOptionMessage();
                }
            } catch (InputMismatchException e) {
                printErrorOptionMessage();
                SCANNER.nextLine();
            }
        }
        return userInput;
    }

    private static boolean isValidInput(int userInput) {
        return userInput >= MIN_VALUE && userInput <= MAX_VALUE;
    }

    private static void printErrorMessage() {
        System.out.println("Помилка. Введiть цiле число вiд " + MIN_VALUE + " до " + MAX_VALUE + ".");
    }

    private static void printErrorOptionMessage() {
        System.out.println("Помилка. Введiть " + optionFirst + " або " + optionSecond);
    }

}
