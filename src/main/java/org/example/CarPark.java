package org.example;




import java.util.*;

public class CarPark {
    private int capacity;

    private List<ParkingSpot> parkingSpots;
    private Sensor entrySensor = new Sensor();
    private Sensor exitSensor = new Sensor();



    private final Map<ParkingSpotType, Integer> spotCount = new HashMap<>();


//    private Map<String, ParkingSpotType> parkingSpotTypeSpacesMap = new HashMap<>();

    public CarPark(int capacity){
        this.capacity = capacity;
    }


    public void setSpotCount(){
        parkingSpots
                .forEach(spot -> spotCount.put(spot.getType(), spotCount.getOrDefault(spot.getType(), 0) + 1));

    }

    private int getSpotCount(ParkingSpotType type){
        return spotCount.get(type);
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

    //    public Map<String, ParkingSpotType> getParkingSpotTypeSpacesMap() {
//        return parkingSpotTypeSpacesMap;
//    }
//
//    public void setParkingSpotTypeSpacesMap(Map<String, ParkingSpotType> parkingSpotTypeSpacesMap) {
//        this.parkingSpotTypeSpacesMap = parkingSpotTypeSpacesMap;
//    }

    public void update() {
        //Place your carpark update logic here.
        //The pseudo code illustrates some of the actions required
        // in conjunction with other classes and will need further refinement.
        //1.  poll car park components (sensor/etc).
        //************************************************
        //3.  if car present at entrance then
        //4.    if ID valid && car park not full then
        //5.      raise barrier and let car pass
        //6.	  endif
        //7.  endif
        //************************************************
        //9.  if car present at exit then
        //10.   raise barrier and let car pass
        //11.   update records and increment spaces
        //12. endif
        //************************************************
        //14. if carpark full then
        //15.   turn on full sign
        //16: else
        //17.   turn off full sign
        //18. endif
        //************************************************
        //...and so on
    }
    
}
