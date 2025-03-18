package org.example.parkingstrategy;

import java.util.TreeSet;

public class FirstAvailableParkingSpotStrategy implements ParkingSpotStrategy{
    private final TreeSet<Integer> availableSpot;

    public FirstAvailableParkingSpotStrategy(int start, int end){
        availableSpot = new TreeSet<>();
        for(int i=start; i<=end; i++){
            availableSpot.add(i);
        }
    }
    @Override
    public Integer findNearestSpot() {
        return availableSpot.first();
    }

    @Override
    public Integer parkCar() {
        return availableSpot.pollFirst();
    }

    @Override
    public void leaveSpot(int spot) {
        availableSpot.add(spot);
    }

    @Override
    public void printAvailableSpots() {
        for(Integer i: availableSpot){
            System.out.printf(i + ", ");
        }
    }

    @Override
    public int getSpacesLeft() {
        return availableSpot.size();
    }
}
