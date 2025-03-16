package org.example.parkingspots;

import org.example.parkingstrategy.ParkingSpotStrategy;

import java.util.PriorityQueue;

public class NormalSpotType extends ParkingSpotType {
    private ParkingSpotStrategy spotStrategy;

    public NormalSpotType(ParkingSpotStrategy strategy){
        this.spotStrategy = strategy;
    }

    public Integer findNearestSpot(){
        return spotStrategy.findNearestSpot();
    }

    public Integer parkCar(){
        return spotStrategy.parkCar();
    }

    public void leaveSpot(int spot){
        spotStrategy.leaveSpot(spot);
    }

    public void printAvailableSpots(){
        spotStrategy.printAvailableSpots();
    }



}
