package org.example.parkingstrategy;

import org.example.ParkingSpot;
import org.example.ParkingSpotStatus;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NearestParkingSpotStrategy implements  ParkingSpotStrategy{
    private final PriorityQueue<ParkingSpot> nearestSpots;


    public NearestParkingSpotStrategy(List<ParkingSpot> spots) {
        nearestSpots = new PriorityQueue<>(Comparator.comparingDouble(ParkingSpot::getDistanceFromEntrance));
        nearestSpots.addAll(spots);

    }

    @Override
    public ParkingSpot findSpot(){
        if(nearestSpots.isEmpty()){
            return null;
        }
        return nearestSpots.peek();
    }

    @Override
    public ParkingSpot parkCar(){
        while(!nearestSpots.isEmpty() && nearestSpots.peek().getStatus() == ParkingSpotStatus.OCCUPIED){
            nearestSpots.poll();
        }
        if(nearestSpots.isEmpty()){
            return null;
        }

        ParkingSpot spot = nearestSpots.poll();
        spot.setStatus(ParkingSpotStatus.OCCUPIED);
        return nearestSpots.poll();
    }

    @Override
    public void leaveSpot(ParkingSpot spot){
        spot.setStatus(ParkingSpotStatus.FREE);
        nearestSpots.add(spot);
    }


}
