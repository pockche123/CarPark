package org.example.utils;

import java.util.Scanner;

public class InputUtils {
    private static Scanner stdin = new Scanner(System.in);

    public static void resetScanner() {
        stdin.close();
        stdin = new Scanner(System.in);
    }

    public static int getValidInput(int min, int max){
        while(true){
            if (!stdin.hasNextInt()) {
                System.err.println("Invalid input! Please enter a number (" + min + "-" + max + ").");
                stdin.nextLine();
                continue;
            }
            int choice = stdin.nextInt();
            stdin.nextLine();
            if (choice >= min && choice <= max) {
                return choice;
            } else {
                System.err.println("Invalid choice! Please enter a number between " + min + " and " + max + ".");
            }
        }
    }

    public static String getValidString(int length){
        while (true) {
            String input = stdin.nextLine();
            if (input.length() != length ) {
                System.err.println("Invalid input! Please enter a valid input.");
                continue;
            }
            return input;
        }
    }

    public static String getValidBarcode(int length){
        while (true) {
            String input = stdin.nextLine();
            if (input.length() != length || !ValidationUtils.isNumber(input) ) {
                System.err.println("Invalid input! Please enter a valid input.");
                continue;
            }
            return input;
        }
    }
}
