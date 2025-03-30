package org.example.menu;

import org.example.*;
import org.example.utils.InputUtils;



public class CarParkMenu {

    private CarPark<Car> carPark;
    private ParkingSpotType spotType;
    private final CarParkManager parkManager;
    private ParkingSpot spot;
    private Car car;

    public CarParkMenu(CarParkManager manager){
        this.parkManager = manager;
    }

    public void start() throws InterruptedException {
        carPark = parkManager.getCarPark();
        parkManager.isCarParkFull();
        while (true) {
            CarParkView.showStartMenu();
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
        CarParkView.showChoiceResults(choice, spaces);
        if(spaces > 0){
            CarParkView.showMembershipType();
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
                    break;
                default:
                    System.err.println("Invalid choice. Please try again.");
                    break;
        }
    }

    private void handleMemberEntry() throws InterruptedException {
        System.out.println("Please enter your barcode: ");
        String barcode = InputUtils.getValidBarcode(10);
        car = new Car(barcode);
        car.setBarcode(barcode);

        boolean carRegistered = parkManager.addMemberRegistry(Long.parseLong(barcode),car);
        if(carRegistered){
            handleSensorDetectCar(car);
        }

    }

    private void handleNonMemberEntry() throws InterruptedException {
        System.out.println("Please enter your reg number: ");
        String reg = InputUtils.getValidString(7);
        car = new Car(reg);
        car.setPlate(reg);
        boolean carRegistered = parkManager.addNonmemberRegistry(reg,car);
        if(carRegistered){
            handleSensorDetectCar(car);
        }

    }

    private boolean detectAndAllowEntry(Car car) throws InterruptedException {
        parkManager.sensorDetectCar(carPark.getEntrySensor(), car);
        boolean sensorDetect = parkManager.isCarDetected(carPark.getEntrySensor());
        if (!sensorDetect) return false;
        parkManager.raiseEntryBarrier();
        Thread.sleep(1000);
        System.out.println("Car Entering ... ");
        Thread.sleep(1000);
        System.out.println("Car Entered");
        Thread.sleep(1000);
        parkManager.decrementSpotCount(spotType);

        return parkManager.isCarDetected(carPark.getEntrySensor());
    }


    private void handleSensorDetectCar(Car car) throws InterruptedException {
            if(detectAndAllowEntry(car)){
                parkManager.sensorUndetectCar(carPark.getEntrySensor());
                parkManager.lowerEntryBarrier();
                parkManager.setEntryTime(car);
                Thread.sleep(1000);
                handleChooseCarSpace();
            }else {
                System.err.println("Something wrong with sensor. Please contact a worker on site...");
            }
    }

    private void handleChooseCarSpace() throws InterruptedException {
        CarParkView.showParkingStrategies();
        int choice = InputUtils.getValidInput(1,3);
        switch(choice) {
            case 1:
                spot = parkManager.parkCar("nearest", spotType);
                System.out.println(spot);
                handleLeaveCarSpace();
                break;
            case 2:
                spot = parkManager.parkCar("first",spotType);
                System.out.println(spot);
                handleLeaveCarSpace();
                break;
            case 3:
                handleLeaveCarPark();
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
                break;
        }

    }

    private void handleLeaveCarSpace() throws InterruptedException {
        System.out.println("Press '1' to leave");
        System.out.println("Press '2' to change parking space.");
        int choice = InputUtils.getValidInput(1,2);
        switch(choice) {
            case 1:
                parkManager.leaveSpot(spot);
                System.out.println(spot);
                handleLeaveCarPark();
                break;
            case 2:
                parkManager.leaveSpot(spot);
                handleChooseCarSpace();
                break;
            default:
                System.err.println("Invalid choice. Please try again");
                break;

        }

    }

    private void handleLeaveCarPark() throws InterruptedException {
        System.out.println("Leaving car park...");
        parkManager.sensorDetectCar(carPark.getExitSensor(), car);
        boolean sensorDetect = parkManager.isCarDetected(carPark.getExitSensor());
        Thread.sleep(1000);
        if(sensorDetect) {
//            payment processing in the future ...
            parkManager.setExitTime(car);
            parkManager.raiseExitBarrier(spot);
            System.out.println("Car Exiting ... ");
            Thread.sleep(1000);
            parkManager.lowerExitBarrier(spotType);
            parkManager.sensorUndetectCar(carPark.getExitSensor());
            parkManager.removeFromRegistry(car);
        }

        Thread.sleep(1000);
        System.out.println("Car has left the car park");
        }


}
