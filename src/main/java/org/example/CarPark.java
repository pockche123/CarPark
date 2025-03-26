package org.example;




import java.util.*;
//refactor this
public class CarPark<T extends Vehicle> {
    private int capacity;
    private List<ParkingSpot> parkingSpots;
    private Sensor entrySensor;
    private Sensor exitSensor;
    private EntryBarrier entryBarrier;
    private ExitBarrier exitBarrier;
    private final Map<ParkingSpotType, Integer> spotCount = new HashMap<>();

//    private Sensor entrySensor = new Sensor();
//    private Sensor exitSensor = new Sensor();
//    private EntryBarrier entryBarrier= new EntryBarrier();
//    private ExitBarrier exitBarrier = new ExitBarrier(null);

    public CarPark(){};

    public CarPark(int capacity){
        this.capacity = capacity;
    }



    public EntryBarrier getEntryBarrier() {
        return entryBarrier;
    }

    public void setEntryBarrier(EntryBarrier entryBarrier) {
        this.entryBarrier = entryBarrier;
    }

    public ExitBarrier getExitBarrier() {
        return exitBarrier;
    }

    public void setExitBarrier(ExitBarrier exitBarrier) {
        this.exitBarrier = exitBarrier;
    }





    public void setSpotCount(){
        parkingSpots
                .forEach(spot -> spotCount.put(spot.getType(), spotCount.getOrDefault(spot.getType(), 0) + 1));

    }

    public int getSpotCount(ParkingSpotType type){
        return  spotCount.get(type);
    }

    public void decrementSpotCount(ParkingSpotType type){
        spotCount.put(type, spotCount.get(type)-1);
    }

    public void incrementSpotCount(ParkingSpotType type){
        spotCount.put(type, spotCount.get(type)+1);
    }

    public void printCarParkSpots(){
        spotCount.forEach((key,val) -> System.out.println(key + ": " + val));
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<ParkingSpotType, Integer> getSpotCount() {
        return spotCount;
    }

    public Sensor getEntrySensor() {
        return entrySensor;
    }

    public void setEntrySensor(Sensor entrySensor) {
        this.entrySensor = entrySensor;
    }

    public Sensor getExitSensor() {
        return exitSensor;
    }

    public void setExitSensor(Sensor exitSensor) {
        this.exitSensor = exitSensor;
    }

    
}
