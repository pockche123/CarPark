package org.example.parkingstrategy;

import org.example.ParkingSpot;

import java.util.PriorityQueue;

public class NearestParkingSpotStrategy implements  ParkingSpotStrategy{
    private final PriorityQueue<Integer> nearestSpot;


    public NearestParkingSpotStrategy(int start, int end){
        nearestSpot = new PriorityQueue<>();
        for(int i=start; i<=end; i++){
            nearestSpot.add(i);
        }
    }

    @Override
    public int findNearestSpot(){
        if(!nearestSpot.isEmpty()) {
            return nearestSpot.peek();
        } else{
            return -1;
        }
    }

    @Override
    public int parkCar(){
        if(!nearestSpot.isEmpty()) {
            return nearestSpot.poll();
        } else{
            return -1;
        }
    }

    @Override
    public void leaveSpot(int spot){
        nearestSpot.add(spot);
    }


    @Override
    public void printAvailableSpots(){
        for(Integer i: nearestSpot){
            System.out.printf(i + ", ");
        }

    }

    @Override
    public int getSpacesLeft() {
        return nearestSpot.size();
    }


}
