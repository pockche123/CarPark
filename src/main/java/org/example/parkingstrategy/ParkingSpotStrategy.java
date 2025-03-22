package org.example.parkingstrategy;

import org.example.ParkingSpot;

public interface ParkingSpotStrategy {
    ParkingSpot findNearestSpot();
    ParkingSpot parkCar();
    void leaveSpot(ParkingSpot spot);
    void printAvailableSpots();


}
