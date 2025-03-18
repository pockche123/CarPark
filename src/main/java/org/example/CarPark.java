package org.example;


import org.example.parkingspots.ParkingSpotType;

import java.util.HashMap;
import java.util.Map;

public class CarPark {
    private double HANDICAPPED_PERCENTAGE = 0.05;
    private double ELECTRIC_PERCENTAGE = 0.05;
    private Map<ParkingSpotType, Integer> parkingSpotTypeSpacesMap = new HashMap<>();

    public Map<ParkingSpotType, Integer> getParkingSpotTypeSpacesMap() {
        return parkingSpotTypeSpacesMap;
    }

    public void setParkingSpotTypeSpacesMap(Map<ParkingSpotType, Integer> parkingSpotTypeSpacesMap) {
        this.parkingSpotTypeSpacesMap = parkingSpotTypeSpacesMap;
    }


//    private int carParkId;
    private int capacity;
    private int freeNormalSpaces;
    private int freeHandicappedSpaces;
    private int freeElectricVehicleSpaces;



//    private Barrier barrier;
//    private Sensor sensor;
//    private IDReader idreader;
//    private FullSign fullSign;
//    private CarRegistry carRegistry;

    public CarPark(int capacity){
        this.capacity = capacity;
        this.freeHandicappedSpaces = (int) (HANDICAPPED_PERCENTAGE * capacity);
        this.freeElectricVehicleSpaces = (int) (ELECTRIC_PERCENTAGE * capacity);
        this.freeNormalSpaces = capacity - this.freeHandicappedSpaces - this.freeElectricVehicleSpaces;
    }




    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
        this.freeHandicappedSpaces = (int) (HANDICAPPED_PERCENTAGE * capacity);
        this.freeElectricVehicleSpaces = (int) (ELECTRIC_PERCENTAGE * capacity);
        this.freeNormalSpaces = capacity - this.freeHandicappedSpaces - this.freeElectricVehicleSpaces;

    }

    public int getFreeElectricVehicleSpaces() {
        return freeElectricVehicleSpaces;
    }

    public void incrementFreeElectricVehicles(){
        freeElectricVehicleSpaces++;
        System.out.println("Free electric spaces: " + freeElectricVehicleSpaces);
    }

    public void decrementFreeElectricVehicles(){
        if(freeElectricVehicleSpaces == 0){
            System.out.println("No free spaces for electric vehicles available");
            return;
        }
        freeElectricVehicleSpaces--;
        System.out.println("Free electric spaces: " + freeElectricVehicleSpaces);
    }

    public void incrementFreeHandicappedSpaces(){
        freeHandicappedSpaces++;
        System.out.println("Free handicapped spaces: " + freeHandicappedSpaces);
    }

    public void decrementFreeHandicappedSpaces(){
        if(freeHandicappedSpaces == 0){
            System.out.println("No free handicapped spaces available");
            return;
        }
        freeHandicappedSpaces--;
        System.out.println("Free handicapped spaces: " + freeHandicappedSpaces);
    }

    public void incrementNormalSpaces(){
        freeNormalSpaces++;
        System.out.println("Free Normal spaces: " + freeNormalSpaces);
    }


    public int getFreeHandicappedSpaces() {
        return freeHandicappedSpaces;
    }

    public int getFreeNormalSpaces() {
        return freeNormalSpaces;
    }

    public int spacesLeft(){
        int spacesLeft = this.freeNormalSpaces + this.freeHandicappedSpaces + this.freeElectricVehicleSpaces;
        return spacesLeft;
    }

    private void setHandicappedPercentage(double percentage){
        HANDICAPPED_PERCENTAGE = percentage;
    }

    private void setElectricPercentage(double percentage){
        ELECTRIC_PERCENTAGE = percentage;
    }


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
