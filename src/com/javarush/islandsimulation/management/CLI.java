package com.javarush.islandsimulation.management;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
    private static final Scanner SCANNER = new Scanner(System.in);

    static int promptForInt(String message) {
        int userInput;

        while (true) {
            try {
                System.out.println(message);
                userInput = SCANNER.nextInt();

                if (userInput > 0 && userInput <= 100) {
                    break;
                } else {
                    System.out.println("Помилка. Введiть цiле число вiд 1 до 100.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка. Введiть цiле число вiд 1 до 100.");
                SCANNER.nextLine();
            }
        }
        return userInput;
    }
}
