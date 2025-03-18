package org.example;

import org.example.builder.CarParkDirector;
import org.example.parkingspots.NormalSpotType;
import org.example.parkingspots.ParkingSpotType;
import org.example.parkingstrategy.ParkingSpotStrategy;

import java.util.Scanner;



public class CarParkMenu {

    private final Scanner stdin = new Scanner(System.in);
    private CarParkDirector director = new CarParkDirector();
    private CarPark carPark;
    private String spotKey;
    private CarParkManager parkManager = new CarParkManager();

    public void showMenu() {
        while (true) {
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
                return;
            }

            String[] spotTypes = {"normal", "handicapped", "electric" };
            String[] spotNames = {"STANDARD", "ACCESSIBLE", "EV"};

            if(choice >=1 && choice <=3){
                int spaces = parkManager.checkForSpaces(carPark, spotTypes[choice-1]);
                if( spaces > 0){
                    spotKey = spotTypes[choice-1];
                    System.out.println("There are currently " + spaces + " spaces available for " + spotNames[choice-1]  + " parking." );
                    pickMemberType();
                } else{
                    System.out.println("Sorry. There are no more " + spotNames[choice-1] + " spaces.");
                }

            } else{
                System.err.println("Invalid choice. Please try again.");
            }

        }
    }

    public void pickMemberType(){
        System.out.println("HELLO " + spotKey);
    }

    private void checkForSpaces(ParkingSpotType spotType){

        }

    private void registerNonMember() {
        while(true) {
            System.out.println("Please enter a valid REG number: ");
            String reg = stdin.nextLine();


            System.out.println("Car");
        }
    }

    private void registerMember() {
        System.out.println("hello you are in member ");
    }
}
