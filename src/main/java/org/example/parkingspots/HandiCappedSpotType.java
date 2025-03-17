package org.example.parkingspots;

import java.util.TreeSet;

public class HandiCappedSpotType extends ParkingSpotType{

    @Override
    public Integer findNearestSpot() {
        return 0;
    }

    @Override
    public Integer parkCar() {
        return 0;
    }

    @Override
    public void leaveSpot(int spot) {

    }

    @Override
    public void printAvailableSpots() {

    }
}
