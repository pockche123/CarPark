package org.example.parkingspots;

import org.example.parkingstrategy.ParkingSpotStrategy;

import java.util.PriorityQueue;

public class NormalSpotType extends ParkingSpotType {
    private ParkingSpotStrategy spotStrategy;


    public NormalSpotType(ParkingSpotStrategy strategy){
        this.spotStrategy = strategy;
    }

    @Override
    public Integer findSpot(){
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
        System.out.println("Normal spots:");
        spotStrategy.printAvailableSpots();
    }

    @Override
    public int getSpacesLeft() {
        return spotStrategy.getSpacesLeft();
    }


}
