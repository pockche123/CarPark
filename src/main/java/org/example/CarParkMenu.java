package org.example;

import org.example.builder.CarParkDirector;
import org.example.parkingspots.NormalSpotType;
import org.example.parkingspots.ParkingSpotType;
import org.example.parkingstrategy.ParkingSpotStrategy;

import java.util.Scanner;



public class CarParkMenu {

    private final Scanner stdin = new Scanner(System.in);
    private CarParkDirector director = new CarParkDirector();

    private CarParkManager parkManager;
    public void showMenu() {
        while (true) {
            System.out.println("--------------- Welcome to PJ's Parking -------------------");
            System.out.println(" Please pick the option for the parking type: ");
            System.out.println(" 1. Standard ");
            System.out.println(" 2. Accessible  ");
            System.out.println(" 3. Electric Vehicles ");
            System.out.println(" 4. Exit ");

            if (!stdin.hasNextInt()) {
                System.err.println("Invalid input! Please enter a number (1-4).");
                stdin.nextLine();
                continue;
            }

            int choice = stdin.nextInt();
            stdin.nextLine();
            CarPark carPark = director.buildAverageCarPark(100);

            switch (choice) {
                case 1:
//                    strategy = new
//                    checkForSpaces(carPark, "normal");
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
