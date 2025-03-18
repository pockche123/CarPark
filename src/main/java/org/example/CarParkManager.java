package org.example;

import org.example.parkingspots.ElectricVehicleSpotType;
import org.example.parkingspots.HandiCappedSpotType;
import org.example.parkingspots.NormalSpotType;
import org.example.parkingspots.ParkingSpotType;
import org.example.parkingstrategy.FirstAvailableParkingSpotStrategy;
import org.example.parkingstrategy.NearestParkingSpotStrategy;
import org.example.parkingstrategy.ParkingSpotStrategy;

import java.util.Scanner;

public class CarParkManager {
    private static Scanner stdin = new Scanner(System.in);
    private CarPark carPark;


//    private Barrier barrier;
//    private Sensor sensor;
//    private IDReader idreader;
//    private FullSign fullSign;
//    private CarRegistry carRegistry;

    public CarParkManager(){}


    public void initialiseCarPark(int capacity){
        // think about how you willl implement the spaces within the strategy
        carPark = new CarPark(capacity);
        int normalSpot = carPark.getFreeNormalSpaces();
        int electricSpot = carPark.getFreeElectricVehicleSpaces();
        int handicappedSpot = carPark.getFreeHandicappedSpaces();

        ParkingSpotStrategy nearestStrategy = new NearestParkingSpotStrategy(1,normalSpot/2);
        ParkingSpotType normal1  = new NormalSpotType(nearestStrategy);

        int start1 = normalSpot/2 + 1;
        int end1 = normalSpot/2 + electricSpot;
        ParkingSpotStrategy firstAvailableStrategy = new FirstAvailableParkingSpotStrategy(start1, end1);
        ParkingSpotType electric = new ElectricVehicleSpotType(firstAvailableStrategy);

        int start2 = end1 + 1;
        int end2 = end1 + handicappedSpot;
        firstAvailableStrategy = new FirstAvailableParkingSpotStrategy(start2,end2);
        ParkingSpotType handicapped = new HandiCappedSpotType(firstAvailableStrategy);


        int start3 = end2 + 1;
        int end3 = capacity %2 == 0 ? end2 + normalSpot/2  : end2 + normalSpot/2 + 1;
        nearestStrategy = new NearestParkingSpotStrategy(start3,end3);
        ParkingSpotType normal2 = new NormalSpotType(nearestStrategy);

    }



    public void enterCarPark()
    {
//        car enter the car park
//        sensor detects the car
//        car selects the parkingspot - if no parkingspot exits else
//        entry barrier opens
//        car is registered into the registry
//        sensor doesn't detect a car
//        entry barrier closes

    }

    public void parkInASpot(){

    }

    public void leaveTheSpot(){

    }

    public void  exitCarPark(){
//        A ticket is generated for the car
    }






}
