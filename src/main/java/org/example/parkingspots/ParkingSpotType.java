package org.example.parkingspots;

public abstract class ParkingSpotType {
    public abstract Integer findNearestSpot();

    public abstract Integer parkCar();

    public abstract void leaveSpot(int spot);

    public abstract void printAvailableSpots();
}
