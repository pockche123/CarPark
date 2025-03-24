package org.example.parkingstrategy;

import org.example.ParkingSpot;
import org.example.ParkingSpotStatus;
import org.example.ParkingSpotType;

import java.util.*;

public class NearestParkingSpotStrategy implements  ParkingSpotStrategy{
    private final PriorityQueue<ParkingSpot> nearestSpots;



    public NearestParkingSpotStrategy(List<ParkingSpot> spots) {
        nearestSpots = new PriorityQueue<>(Comparator
                .comparingDouble(ParkingSpot::getDistanceFromEntrance)
                .thenComparing((ParkingSpot spot) -> spot.getStatus() == ParkingSpotStatus.FREE? 0:1));


        nearestSpots.addAll(spots);

    }

    @Override
    public ParkingSpot findSpot(ParkingSpotType type){
        for(ParkingSpot spot: nearestSpots){
            if(spot.getStatus() == ParkingSpotStatus.FREE && spot.getType() == type ){
                return spot;
            }
        }
        return null;

    }

    @Override
    public ParkingSpot parkCar(ParkingSpotType type ){

        PriorityQueue<ParkingSpot> clonedQueue = new PriorityQueue<>(nearestSpots);

        while (!clonedQueue.isEmpty()) {
            ParkingSpot spot = clonedQueue.poll();
            if (spot.getStatus() == ParkingSpotStatus.FREE && spot.getType() == type) {
                nearestSpots.remove(spot);
                spot.setStatus(ParkingSpotStatus.OCCUPIED);
                nearestSpots.add(spot);
                return spot;
            }
        }
        return null;

    }

    @Override
    public void leaveSpot(ParkingSpot spot){
        nearestSpots.remove(spot);
        spot.setStatus(ParkingSpotStatus.FREE);
        nearestSpots.add(spot);

    }


}
