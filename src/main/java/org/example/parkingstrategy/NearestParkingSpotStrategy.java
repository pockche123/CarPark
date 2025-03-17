package org.example.parkingstrategy;

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
    public Integer findNearestSpot(){
        return nearestSpot.peek();
    }

    @Override
    public Integer parkCar(){
        return nearestSpot.poll();
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


}
