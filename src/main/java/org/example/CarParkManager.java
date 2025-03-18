package org.example;

import org.example.builder.CarParkDirector;
import org.example.parkingspots.ParkingSpotType;
import org.example.utils.ValidationUtils;

import java.util.Map;
import java.util.Scanner;

public class CarParkManager {

    private CarParkDirector director;


//    private Barrier barrier;
//    private Sensor sensor;
//    private IDReader idreader;
//    private FullSign fullSign;
//    private CarRegistry carRegistry;

    public CarParkManager(){}

    public int checkForSpaces(CarPark park, String key){
        Map<String, ParkingSpotType> map = park.getParkingSpotTypeSpacesMap();
        if(key.equalsIgnoreCase("normal")){
            return map.get("normal1").getSpacesLeft() + map.get("normal2").getSpacesLeft();
        } else if(!map.containsKey(key)){
            return -1;
        } else {
            return map.get(key.toLowerCase()).getSpacesLeft();
        }
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
