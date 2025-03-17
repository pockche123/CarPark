package org.example.parkingspots;

import org.example.parkingstrategy.ParkingSpotStrategy;

import java.util.TreeSet;

public class HandiCappedSpotType extends ParkingSpotType{

    private ParkingSpotStrategy parkingSpotStrategy;

    public HandiCappedSpotType(ParkingSpotStrategy parkingSpotStrategy){
        this.parkingSpotStrategy = parkingSpotStrategy;
    }
    @Override
    public Integer findNearestSpot() {
        return parkingSpotStrategy.findNearestSpot();
    }

    @Override
    public Integer parkCar() {
        return parkingSpotStrategy.parkCar();
    }

    @Override
    public void leaveSpot(int spot) {
        parkingSpotStrategy.leaveSpot(spot);
    }

    @Override
    public void printAvailableSpots() {
        parkingSpotStrategy.printAvailableSpots();
    }
}
