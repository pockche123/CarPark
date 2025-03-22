package org.example;

import org.example.builder.CarParkDirector;

import org.example.utils.ValidationUtils;

import java.util.Map;
import java.util.Scanner;

public class CarParkManager {

    private CarParkDirector director = new CarParkDirector();
    private CarRegistry registry = new CarRegistry();
    private MemberCarRegistry memberCarRegistry = new MemberCarRegistry();
    private EntryBarrier entryBarrier = new EntryBarrier();
    private Sensor sensor = new Sensor();



//    private Barrier barrier;
//    private Sensor sensor;
//    private IDReader idreader;
//    private FullSign fullSign;
//    private CarRegistry carRegistry;

    public CarParkManager(){

    }

    public CarPark initCarPark(int capacity){
        return director.buildAverageCarPark(capacity);
    }

    public int checkForSpaces(CarPark park, ParkingSpotType type){
        return park.printCarParkSpots();
    }

    public boolean addNonmemberRegistry(String reg, Car car){
        return registry.addCar(reg, car);
    }

    public boolean addMemberRegistry(int barcode, Car car){
        return memberCarRegistry.addCar(String.valueOf(barcode), car);
    }

    public void sensorDetectCar(Car car){
        sensor.setCar(car);
    }

    public void sensorUndetectCar(){
        sensor.setCar(null);
    }

    public boolean isCarDetected(){
        return sensor.isCarPresent();
    }

    public void raiseEntryBarrier(){
        entryBarrier.raise();
    }

    public void lowerEntryBarrier(){
        entryBarrier.lower();
    }






//    public void enterCarPark()
//    {
////        car enter the car park
//
//        String plate = stdin.nextLine();
//        Car car = new Car("UJZ8884");
////        sensor detects the car
//        Sensor sensor = new Sensor(car);
//
////        car selects the parkingspot - if no parkingspot exits else
//        System.out.println("Please select a parking spot option (1-3)");
//        System.out.println("1. Standard");
//        System.out.println("2. Electric Vehicle");
//        System.out.println("3. Handicap");
//        String option = stdin.nextLine();
//
//        while(!ValidationUtils.checkValidOption(option,1,3)){
//            System.err.println("Please pick a valid option");
//            option = stdin.nextLine();
//        }
//
//
//
//
////        entry barrier opens
////        car is registered into the registry
////        sensor doesn't detect a car
////        entry barrier closes
//
//    }



//    public boolean checkValidOption(String option){
//        boolean numeric = false;
//        try{
//            int num = Integer.parseInt(option);
//        } catch(NumberFormatException e){
//
//        }
//
//
//    }

    public void parkInASpot(){

    }

    public void leaveTheSpot(){

    }

    public void  exitCarPark(){
//        A ticket is generated for the car
    }






}
