package org.example.parkingstrategy;

public interface ParkingSpotStrategy {
    int findNearestSpot();
    int parkCar();
    void leaveSpot(int spot);
    void printAvailableSpots();
    int getSpacesLeft();


}
