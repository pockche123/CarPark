package org.example;

import org.example.builder.CarParkDirector;

import org.example.parkingstrategy.OrderedParkingSpotStrategy;
import org.example.parkingstrategy.NearestParkingSpotStrategy;


import java.io.IOException;
import java.time.LocalDateTime;


public class CarParkManager {


    private CarRegistry registry;
    private MemberCarRegistry memberCarRegistry;
    private EntryBarrier entryBarrier;
    private NearestParkingSpotStrategy nearestStrategy;
    private OrderedParkingSpotStrategy firstStrategy;
    private FullSign fullSign;

    private BarcodeReader barcodeReader;
    private PlateNumberReader plateNumberReader;
    private CarPark<Car> carPark;

    public CarParkManager(){};
    public CarParkManager( PlateNumberReader plateReader,
                          MemberCarRegistry memberCarRegistry, BarcodeReader barcodeReader,
                          CarRegistry carRegistry) {
        this.plateNumberReader = plateReader;
        this.memberCarRegistry = memberCarRegistry;
        this.barcodeReader = barcodeReader;
        this.registry = carRegistry;
    }


    public CarPark<Car> getCarPark() {
        return carPark;
    }

    public void setCarPark(CarPark<Car> carPark) {
        this.carPark = carPark;
    }

    public PlateNumberReader getPlateNumberReader() {
        return plateNumberReader;
    }

    public void setPlateNumberReader(PlateNumberReader plateNumberReader) {
        this.plateNumberReader = plateNumberReader;
    }

    public BarcodeReader getBarcodeReader() {
        return barcodeReader;
    }

    public void setBarcodeReader(BarcodeReader barcodeReader) {
        this.barcodeReader = barcodeReader;
    }

    public FullSign getFullSign() {
        return fullSign;
    }

    public void setFullSign(FullSign fullSign) {
        this.fullSign = fullSign;
    }

    public OrderedParkingSpotStrategy getFirstStrategy() {
        return firstStrategy;
    }

    public void setFirstStrategy(OrderedParkingSpotStrategy firstStrategy) {
        this.firstStrategy = firstStrategy;
    }

    public NearestParkingSpotStrategy getNearestStrategy() {
        return nearestStrategy;
    }

    public void setNearestStrategy(NearestParkingSpotStrategy nearestStrategy) {
        this.nearestStrategy = nearestStrategy;
    }

    public EntryBarrier getEntryBarrier() {
        return entryBarrier;
    }

    public void setEntryBarrier(EntryBarrier entryBarrier) {
        this.entryBarrier = entryBarrier;
    }

    public MemberCarRegistry getMemberCarRegistry() {
        return memberCarRegistry;
    }

    public void setMemberCarRegistry(MemberCarRegistry memberCarRegistry) {
        this.memberCarRegistry = memberCarRegistry;
    }

    public CarRegistry getRegistry() {
        return registry;
    }

    public void setRegistry(CarRegistry registry) {
        this.registry = registry;
    }

//    public CarPark<Car> initCarPark() throws IOException {
//        nearestStrategy = new NearestParkingSpotStrategy(carPark.getParkingSpots());
//        firstStrategy = new OrderedParkingSpotStrategy(carPark.getParkingSpots());
//        return carPark;
//    }

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
