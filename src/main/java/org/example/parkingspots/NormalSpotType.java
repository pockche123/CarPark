package org.example.parkingspots;

import org.example.parkingstrategy.ParkingSpotStrategy;

import java.util.PriorityQueue;

public class NormalSpotType extends ParkingSpotType {
    private ParkingSpotStrategy spotStrategy;


    public NormalSpotType(ParkingSpotStrategy strategy){
        this.spotStrategy = strategy;
    }

    @Override
    public Integer findNearestSpot(){
        return spotStrategy.findNearestSpot();
    }

    @Override
    public Integer parkCar(){
        return spotStrategy.parkCar();
    }

    @Override
    public void leaveSpot(int spot){
        spotStrategy.leaveSpot(spot);
    }

    @Override
    public void printAvailableSpots(){
        spotStrategy.printAvailableSpots();
    }



}
