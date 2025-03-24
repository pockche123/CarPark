package org.example.menu;

import org.example.*;
import org.example.builder.CarParkDirector;
import org.example.parkingstrategy.FirstAvailableParkingSpotStrategy;
import org.example.parkingstrategy.NearestParkingSpotStrategy;
import org.example.parkingstrategy.ParkingSpotStrategy;
import org.example.utils.InputUtils;
import org.example.utils.ValidationUtils;

import java.util.Scanner;



public class CarParkMenu {

    private final Scanner stdin = new Scanner(System.in);
    private CarPark carPark;
    private String reg;
    private String barcode;
    private ParkingSpotType spotType;
    private final CarParkManager parkManager = new CarParkManager();
    private final CarParkView parkView = new CarParkView();
    private ParkingSpot spot;
    private Car car;


    public void start() throws InterruptedException {
        carPark = parkManager.initCarPark(100);
        parkManager.isCarParkFull(carPark);
        while (true) {
            parkView.showStartMenu();
            int choice = InputUtils.getValidInput(1,4);
            if(choice == 4){
                System.out.println("Exiting menu...");
                break;
            }
            handleSpaceChoice(choice);
        }
    }

    public void handleSpaceChoice(int choice) throws InterruptedException {
        ParkingSpotType[] spotTypes = ParkingSpotType.values();
        spotType = spotTypes[choice-1];
        int spaces = parkManager.getSpotCount(spotType);
        parkView.showChoiceResults(choice, spaces);
        if(spaces > 0){
            parkView.showMembershipType();
            int membershipChoice = InputUtils.getValidInput(1,4);
            handleUserChoice(membershipChoice);
        }

    }

    public void handleUserChoice(int choice) throws InterruptedException {
            switch(choice){
                case 1:
                    handleMemberEntry();
                    break;
                case 2:
                    handleNonMemberEntry();
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

    private void handleMemberEntry() throws InterruptedException {
        System.out.println("Please enter your barcode: ");
        barcode = InputUtils.getValidBarcode(10);
        car = new Car(barcode);
        car.setBarcode(barcode);

        boolean carRegistered = parkManager.addMemberRegistry(Long.parseLong(barcode),car);
        if(carRegistered){
            handleSensorDetectCar(car);
        }


    }

    private void handleNonMemberEntry() throws InterruptedException {
        System.out.println("Please enter your reg number: ");
        reg = InputUtils.getValidString(7);
        car = new Car(reg);
        car.setPlate(reg);
        boolean carRegistered = parkManager.addNonmemberRegistry(reg,car);
        if(carRegistered){
            handleSensorDetectCar(car);
        }

    }

    private void handleSensorDetectCar(Car car) throws InterruptedException {
        parkManager.sensorDetectCar(carPark.getEntrySensor(), car);
        boolean sensorDetect = parkManager.isCarDetected(carPark.getEntrySensor());
        if(sensorDetect){
            parkManager.raiseEntryBarrier();
            Thread.sleep(1000);
            System.out.println("Car Entering ... ");
            Thread.sleep(1000);
            System.out.println("Car Entered");
            Thread.sleep(1000);
            parkManager.decrementSpotCount(spotType);
            parkManager.sensorUndetectCar(carPark.getEntrySensor());
            sensorDetect = parkManager.isCarDetected(carPark.getEntrySensor());
            if(!sensorDetect){
                parkManager.lowerEntryBarrier();
                Thread.sleep(1000);
                handleChooseCarSpace();
            }
        }
    }

    private void handleChooseCarSpace() throws InterruptedException {
        parkView.showParkingStrategies();
        int choice = InputUtils.getValidInput(1,3);
        switch(choice) {
            case 1:
                spot = parkManager.parkCar("nearest", spotType);
                System.out.println(spot);
                handleUnParkCarSpace();
                break;
            case 2:
                spot = parkManager.parkCar("first",spotType);
                System.out.println(spot);
                handleUnParkCarSpace();
                break;
            case 3:
                handleLeaveCarPark();
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
                break;
        }

    }

    private void handleUnParkCarSpace() throws InterruptedException {
        System.out.println("Press 'x' to unpark");
        String choice = stdin.nextLine();
        while (!choice.equalsIgnoreCase("x")) {
            System.err.println("Invalid choice. Please try again.");
            choice = stdin.nextLine();
        }

        parkManager.leaveSpot(spot);
        System.out.println(spot);
        handleLeaveCarPark();
    }

    private void handleLeaveCarPark() throws InterruptedException {
        System.out.println("Leaving car park...");
        parkManager.sensorDetectCar(carPark.getExitSensor(), car);
        boolean sensorDetect = parkManager.isCarDetected(carPark.getExitSensor());
        Thread.sleep(1000);
        if(sensorDetect) {
            parkManager.raiseExitBarrier(spot);
            System.out.println("Car Exiting ... ");
            Thread.sleep(1000);
            parkManager.lowerExitBarrier(spotType);
            parkManager.sensorUndetectCar(carPark.getExitSensor());
        }

        Thread.sleep(1000);
        System.out.println("Car has left the car park");
        }


}
