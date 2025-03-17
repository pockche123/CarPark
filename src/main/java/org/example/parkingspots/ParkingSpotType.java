package org.example.parkingspots;

public abstract class ParkingSpotType {
    public abstract Integer findSpot();

    public abstract Integer parkCar();

    public abstract void leaveSpot(int spot);

    public abstract void printAvailableSpots();
}
