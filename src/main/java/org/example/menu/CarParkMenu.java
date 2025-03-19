package org.example.menu;

import org.example.CarPark;
import org.example.CarParkManager;
import org.example.builder.CarParkDirector;

import java.util.Scanner;



public class CarParkMenu {

    private final Scanner stdin = new Scanner(System.in);
    private CarParkDirector director = new CarParkDirector();
    private CarPark carPark;
    private String spotKey;
    private CarParkManager parkManager = new CarParkManager();
    private boolean run  = true;
    private final CarParkView parkView = new CarParkView();

    public void start() {
        while (run) {
            parkView.showStartMenu();
            int choice = getValidInput(1,4);
            carPark = director.buildAverageCarPark(100);
            if(choice == 4){
                System.out.println("Exiting menu...");
                run = false;
                break;
            }
            handleSpaceChoice(choice);
        }
    }

    public void handleSpaceChoice(int choice){
        String[] spotTypes = {"normal", "handicapped", "electric" };
        int spaces = parkManager.checkForSpaces(carPark, spotTypes[choice-1]);
        parkView.showChoiceResults(choice, spaces);
        if(spaces > 0){
            parkView.showMembershipType();
            int membershipChoice = getValidInput(1,4);
            handleMemberChoice(membershipChoice);
        }

    }

    public void handleMemberChoice(int choice){
            switch(choice){
                case 1:
                    showMemberRegistration();
                    break;
                case 2:
                    showNonMemberRegistration();
                    break;
                case 3:
                    return;
                case 4:
                    System.out.println("Exiting menu...");
                    run = false;
                    break;
                default:
                    System.err.println("Invalid choice. Please try again.");
                    break;
        }
    }


    private void showNonMemberRegistration() {
        while(true) {
            System.out.println("Please enter a valid REG number: ");
            String reg = stdin.nextLine();


            System.out.println("Car");
        }
    }

    private void showMemberRegistration() {
        System.out.println("hello you are in member ");
    }

    private int getValidInput(int min, int max){
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

}
