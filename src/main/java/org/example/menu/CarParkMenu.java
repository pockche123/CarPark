package org.example.menu;

import org.example.*;
import org.example.builder.CarParkDirector;
import org.example.utils.ValidationUtils;

import java.util.Scanner;



public class CarParkMenu {

    private final Scanner stdin = new Scanner(System.in);
    private CarParkDirector director = new CarParkDirector();
    private CarPark carPark;
    private String spotKey;
    private String reg;
    private String barcode;
    private CarParkManager parkManager = new CarParkManager();
    private boolean run  = true;
    private final CarParkView parkView = new CarParkView();



    public void start() throws InterruptedException {
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

    public void handleSpaceChoice(int choice) throws InterruptedException {
//        String[] spotTypes = {"normal", "handicapped", "electric" };
        ParkingSpotType[] spotTypes = ParkingSpotType.values();
        int spaces = parkManager.checkForSpaces(carPark, spotTypes[choice-1]);
        parkView.showChoiceResults(choice, spaces);
        if(spaces > 0){
            parkView.showMembershipType();
            int membershipChoice = getValidInput(1,4);
            handleMemberChoice(membershipChoice);
        }

    }

    public void handleMemberChoice(int choice) throws InterruptedException {
            switch(choice){
                case 1:
                    handleMemberRegistration();
                    break;
                case 2:
                    handleNonMemberRegistration();
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

    private void handleMemberRegistration() throws InterruptedException {
        System.out.println("Please enter your barcode: ");
        barcode = getValidBarcode(10);
        Car car = new Car(barcode);
        boolean carRegistered = parkManager.addNonmemberRegistry(barcode,car);
        if(carRegistered){
            handleSensorDetectCar(car);
        }


    }

    private void handleNonMemberRegistration() throws InterruptedException {
        System.out.println("Please enter your reg number: ");
        reg = getValidString(7);
        Car car = new Car(reg);
        boolean carRegistered = parkManager.addNonmemberRegistry(reg,car);
        if(carRegistered){
            handleSensorDetectCar(car);
        }

    }

    private void handleSensorDetectCar(Car car) throws InterruptedException {
        parkManager.sensorDetectCar(car);
        boolean sensorDetect = parkManager.isCarDetected();
        if(sensorDetect){
            parkManager.raiseEntryBarrier();
            System.out.println("Car Entering ... ");
            Thread.sleep(5000);
            System.out.println("Car Entered");
            parkManager.sensorUndetectCar();
            sensorDetect = parkManager.isCarDetected();
            if(!sensorDetect){
                parkManager.lowerEntryBarrier();
                handleChooseCarSpace();
            }
        }
    }

    private void handleChooseCarSpace(){
        System.out.println("Choosing car space");
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

    private String getValidString(int length){
        while (true) {
            String input = stdin.nextLine();
            if (input.length() != length ) {
                System.err.println("Invalid input! Please enter a valid input.");
                continue;
            }
            return input;
        }
    }

    private String getValidBarcode(int length){
        while (true) {
            String input = stdin.nextLine();
            if (input.length() != length || !ValidationUtils.isNumber(input) ) {
                System.err.println("Invalid input! Please enter a valid input.");
                continue;
            }
            return input;
        }
    }


// next remove when you go back from cancelling the registration
//    car enters the car park
//    picks the spot


}
