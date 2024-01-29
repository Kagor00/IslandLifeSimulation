package com.javarush.islandsimulation.management;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int promptForInt(String message) {
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

    public static int promptForOption() {
        int userInput;

        while (true) {
            try {
                System.out.println("____________________________________________________________________________________________________________________");
                System.out.println("Введiть 1, якщо Ви хочете запустити симуляцiю i перевiрити скiльки днiв проживе популяцiя тварин на островi ");
                System.out.println("____________________________________________________________________________________________________________________");
                System.out.println("Введiть 2, якщо Ви хочете запустити симуляцiю на фiксовану кiлькiсть днiв i отримати статистику за вказаний перiод ");
                System.out.println("____________________________________________________________________________________________________________________");

                userInput = SCANNER.nextInt();

                if (userInput == 1 || userInput == 2) {
                    break;
                } else {
                    System.out.println("Помилка. Введiть 1 або 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка. Введiть 1 або 2.");
                SCANNER.nextLine();
            }
        }
        return userInput;
    }
}
