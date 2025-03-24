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
    private BarcodeReader barcodeReader = new BarcodeReader();
    private PlateNumberReader plateNumberReader = new PlateNumberReader();

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


    public boolean addNonmemberRegistry(String reg, Car car){
        if(car == null){
            System.out.println("Car is null");
            return false;
        }
        if(car.getPlate() == null){
            System.out.println("the car plate is null");
            return false;
        }
        String regFetched = plateNumberReader.read(car);
        if(regFetched == null){
            System.out.println("fetched plate is null");
            return false;
        }
        return plateNumberReader.read(car).equalsIgnoreCase(reg) && registry.addCar(reg, car);
    }


    public boolean addMemberRegistry(long barcode, Car car){
        if (car == null) {
            System.out.println("Car is null.");
            return false;
        }

        if(car.getBarcode() == null){
            System.out.println("the barcode is null");
            return false;
        }
        String plateNumber = barcodeReader.read(car);  // Read the plate number
        if (plateNumber == null) {
            return false;
        }
        return plateNumber.equalsIgnoreCase(String.valueOf(barcode)) && memberCarRegistry.addCar(String.valueOf(barcode), car);
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


    public void isCarParkFull(CarPark carPark){
        for(ParkingSpotType type: ParkingSpotType.values()){
            if(carPark.getSpotCount(type) > 0){
                fullSign.switchOff();
                return;
            };
        }
        fullSign.switchOn();

    }






}
