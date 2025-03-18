package org.example.parkingstrategy;

public interface ParkingSpotStrategy {
    Integer findNearestSpot();
    Integer parkCar();
    void leaveSpot(int spot);
    void printAvailableSpots();
    int getSpacesLeft();
}
