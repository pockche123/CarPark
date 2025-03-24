package org.example;

import org.example.builder.CarParkDirector;

import org.example.parkingstrategy.FirstAvailableParkingSpotStrategy;
import org.example.parkingstrategy.NearestParkingSpotStrategy;
import org.example.parkingstrategy.ParkingSpotStrategy;
import org.example.utils.ValidationUtils;

import java.util.Map;
import java.util.Scanner;

public class CarParkManager {

    private CarParkDirector director = new CarParkDirector();
    private CarRegistry registry = new CarRegistry();
    private MemberCarRegistry memberCarRegistry = new MemberCarRegistry();
    private EntryBarrier entryBarrier = new EntryBarrier();

    private NearestParkingSpotStrategy nearestStrategy;
    private FirstAvailableParkingSpotStrategy firstStrategy;
    private FullSign fullSign = new FullSign();



//    private Barrier barrier;
//    private Sensor sensor;
//    private IDReader idreader;
//    private FullSign fullSign;
//    private CarRegistry carRegistry;

    public CarParkManager(){

    }

    public CarPark initCarPark(int capacity){
        CarPark park = director.buildAverageCarPark(capacity);
        return park;
    }

    public int checkForSpaces(CarPark park, ParkingSpotType type){
        return park.getSpotCount(type);
    }

    public boolean addNonmemberRegistry(String reg, Car car){
        return registry.addCar(reg, car);
    }

    public boolean removeNonmemberRegistry(String reg){
        return registry.removeCar(reg);
    }

    public boolean addMemberRegistry(int barcode, Car car){
        return memberCarRegistry.addCar(String.valueOf(barcode), car);
    }

    public boolean removeMemberRegistry(String barcode){
        return memberCarRegistry.removeCar(barcode);
    }

    public void sensorDetectCar(Sensor sensor, Car car){
        sensor.setCar(car);
    }

    public void sensorUndetectCar(Sensor sensor){
        sensor.setCar(null);
    }

    public boolean isCarDetected(Sensor sensor){
        return sensor.isCarPresent();
    }

    public void raiseEntryBarrier(){
        entryBarrier.raise();
    }

    public void lowerEntryBarrier(){
        entryBarrier.lower();
    }

    public ParkingSpot parkCar(ParkingSpotStrategy spotStrategy, ParkingSpotType type){
        return spotStrategy.parkCar(type);
    }

    public void unparkCar(ParkingSpot spot){}

    public boolean isCarParkFull(CarPark carPark){
        for(ParkingSpotType type: ParkingSpotType.values()){
            if(carPark.getSpotCount(type) > 0){
                fullSign.switchOff();
                return false;
            };
        }
        fullSign.switchOn();
        return true;
    }






}
