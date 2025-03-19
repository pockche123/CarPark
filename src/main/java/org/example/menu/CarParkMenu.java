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

    public void showMenu() {
        while (run) {
            System.out.println("--------------- Welcome to PJ's Parking -------------------");
            System.out.println(" Please pick the option for the parking type: ");
            System.out.println(" 1. Standard ");
            System.out.println(" 2. Accessible  ");
            System.out.println(" 3. Electric Vehicles (EV) ");
            System.out.println(" 4. Exit ");

            if (!stdin.hasNextInt()) {
                System.err.println("Invalid input! Please enter a number (1-4).");
                stdin.nextLine();
                continue;
            }

            int choice = stdin.nextInt();
            stdin.nextLine();
            carPark = director.buildAverageCarPark(100);

            if(choice == 4){
                System.out.println("Exiting menu...");
                run = false;
                break;
            }

            showChoiceResults(choice);
        }
    }

    public void showChoiceResults(int choice){
        String[] spotTypes = {"normal", "handicapped", "electric" };
        String[] spotNames = {"STANDARD", "ACCESSIBLE", "EV"};
        if(choice >=1 && choice <=3){
            int spaces = parkManager.checkForSpaces(carPark, spotTypes[choice-1]);
            if( spaces > 0){
                spotKey = spotTypes[choice-1];
                System.out.println("There are currently " + spaces + " spaces available for " + spotNames[choice-1]  + " parking." );
                showMemberType();
            } else{
                System.out.println("Sorry. There are no more " + spotNames[choice-1] + " spaces.");
            }

        } else{
            System.err.println("Invalid choice. Please try again.");
        }
    }

    public void showMemberType(){
        while(run) {
            System.out.println("Please select the type of membership: ");
            System.out.println("1. Member");
            System.out.println("2. Non-member");
            System.out.println("3. Go back");
            System.out.println("4. Exit");
            if (!stdin.hasNextInt()) {
                System.err.println("Invalid input! Please enter a number (1-4).");
                stdin.nextLine();
                continue;
            }
            int choice = stdin.nextInt();
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
}
