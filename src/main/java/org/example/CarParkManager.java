package org.example;


import org.example.parkingstrategy.OrderedParkingSpotStrategy;
import org.example.parkingstrategy.NearestParkingSpotStrategy;
import org.example.parkingstrategy.ParkingSpotStrategy;


import java.time.LocalDateTime;

//have removeFROmRegisty methods
public class CarParkManager {

    private CarRegistry registry;
    private MemberCarRegistry memberCarRegistry;
    private ParkingSpotStrategy nearestStrategy;
    private ParkingSpotStrategy firstStrategy;
    private CarPark<Car> carPark;


    public CarParkManager(){};

    public CarPark<Car> getCarPark() {
        return carPark;
    }

    public void setCarPark(CarPark<Car> carPark) {
        this.carPark = carPark;
    }



    public ParkingSpotStrategy getFirstStrategy() {
        return firstStrategy;
    }

    public void setFirstStrategy(OrderedParkingSpotStrategy firstStrategy) {
        this.firstStrategy = firstStrategy;
    }

    public ParkingSpotStrategy getNearestStrategy() {
        return nearestStrategy;
    }

    public void setNearestStrategy(NearestParkingSpotStrategy nearestStrategy) {
        this.nearestStrategy = nearestStrategy;
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

    public int getSpotCount(ParkingSpotType spotType){
        return carPark.getSpotCount(spotType);
    }

    public void removeFromRegistry(Car car){
        memberCarRegistry.removeCar(car.getBarcode());
        registry.removeCar(car.getPlate());
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
        String regFetched = carPark.getPlateNumberReader().read(car);
        if(regFetched == null){
            System.out.println("fetched plate is null");
            return false;
        }
        return carPark.getPlateNumberReader().read(car).equalsIgnoreCase(reg) && registry.addCar(reg, car);
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
        String plateNumber = carPark.getBarcodeReader().read(car);
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
        carPark.getEntryBarrier().raise();
    }

    public void lowerEntryBarrier(){
        carPark.getEntryBarrier().lower();
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


    public  void isCarParkFull(){
        for(ParkingSpotType type: ParkingSpotType.values()){
            if(carPark.getSpotCount(type) > 0){
                carPark.getFullSign().switchOff();
                return;
            };
        }
        carPark.getFullSign().switchOn();

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
