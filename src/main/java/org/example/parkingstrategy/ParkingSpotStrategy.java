package org.example.parkingstrategy;

import org.example.ParkingSpot;

public interface ParkingSpotStrategy {
    ParkingSpot findSpot();
    ParkingSpot parkCar();
    void leaveSpot(ParkingSpot spot);



}
