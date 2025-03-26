package org.example;

import org.example.builder.CarParkDirector;

import org.example.parkingstrategy.OrderedParkingSpotStrategy;
import org.example.parkingstrategy.NearestParkingSpotStrategy;


import java.io.IOException;
import java.time.LocalDateTime;


public class CarParkManager {

    private CarParkDirector director = new CarParkDirector();
    private CarRegistry registry = new CarRegistry();
    private MemberCarRegistry memberCarRegistry = new MemberCarRegistry();
    private final EntryBarrier entryBarrier = new EntryBarrier();
    private NearestParkingSpotStrategy nearestStrategy;
    private OrderedParkingSpotStrategy firstStrategy;
    private final FullSign fullSign = new FullSign();
    private BarcodeReader barcodeReader = new BarcodeReader();
    private PlateNumberReader plateNumberReader = new PlateNumberReader();
    private CarPark<Car> carPark;

    public CarParkManager(CarParkDirector director, PlateNumberReader plateReader,
                          MemberCarRegistry memberCarRegistry, BarcodeReader barcodeReader,
                          CarRegistry carRegistry) {
        this.director = director;
        this.plateNumberReader = plateReader;
        this.memberCarRegistry = memberCarRegistry;
        this.barcodeReader = barcodeReader;
        this.registry = carRegistry;
    }



    public CarPark<Car> initCarPark() throws IOException {
        carPark = director.buildPreMadeCarPark();
        nearestStrategy = new NearestParkingSpotStrategy(carPark.getParkingSpots());
        firstStrategy = new OrderedParkingSpotStrategy(carPark.getParkingSpots());
        return carPark;
    }

    public int getSpotCount(ParkingSpotType spotType){
        return carPark.getSpotCount(spotType);
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
        String plateNumber = barcodeReader.read(car);
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

    public void decrementSpotCount(ParkingSpotType spotType){
        carPark.decrementSpotCount(spotType);
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

    public ParkingSpot parkCar(String strategy, ParkingSpotType type){
        if(strategy.equalsIgnoreCase("nearest")){
            return nearestStrategy.parkCar(type);
        } else{
            return firstStrategy.parkCar(type);
        }
    }

    public void leaveSpot(ParkingSpot spot){
        nearestStrategy.leaveSpot(spot);
        firstStrategy.leaveSpot(spot);
    }


    public <T extends Vehicle> void isCarParkFull(CarPark<T> carPark){
        for(ParkingSpotType type: ParkingSpotType.values()){
            if(carPark.getSpotCount(type) > 0){
                fullSign.switchOff();
                return;
            };
        }
        fullSign.switchOn();

    }

    public void raiseExitBarrier(ParkingSpot spot){
        carPark.getExitBarrier().setTicket(spot);
        carPark.getExitBarrier().raise();


    }

    public void setEntryTime(Car car){
        car.setEnterTime(LocalDateTime.now());
    }

    public void setExitTime(Car car){
        car.setLeaveTime(LocalDateTime.now());
    }

    public void lowerExitBarrier(ParkingSpotType spotType){
        carPark.getExitBarrier().lower();
        carPark.incrementSpotCount(spotType);
        carPark.getExitBarrier().setTicket(null);
    }
}
