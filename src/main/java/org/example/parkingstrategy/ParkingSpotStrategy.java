package org.example.parkingstrategy;

import org.example.ParkingSpot;
import org.example.ParkingSpotType;

public interface ParkingSpotStrategy {
    ParkingSpot findSpot(ParkingSpotType type);
    ParkingSpot parkCar(ParkingSpotType type);
    void leaveSpot(ParkingSpot spot);


}
