package org.example;

import java.util.Scanner;

public class CarParkMenu {

    private final Scanner stdin = new Scanner(System.in);
    public void showMenu(){
        while(true){
            System.out.println("--------------- Welcome to PJ's Parking -------------------");
            System.out.println(" OPTION ");
            System.out.println(" 1. Member ");
            System.out.println(" 2. Non-member ");
            System.out.println(" 3. Exit menu ");

            if (!stdin.hasNextInt()) {
                System.err.println("Invalid input! Please enter a number (1-3).");
                stdin.nextLine();
                continue;
            }

            int choice = stdin.nextInt();
            stdin.nextLine();

            switch(choice){
                case 1:
                    registerMember();
                    break;
                case 2:
                    registerNonMember();
                    break;
                case 3:
                    System.out.println("Exiting menu...");
                    return;
                default:
                    System.err.println("Invalid choice. Please try again.");
                    break;


            }





        }
    }

    private void registerNonMember() {
        System.out.println("hello you are in non- member");
    }

    private void registerMember() {
        System.out.println("hello you are in member ");
    }
}
