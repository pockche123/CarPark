package org.example.parkingstrategy;

import org.example.ParkingSpot;
import org.example.ParkingSpotStatus;
import org.example.ParkingSpotType;

import java.util.*;

public class NearestParkingSpotStrategy implements  ParkingSpotStrategy{
    private final PriorityQueue<ParkingSpot> nearestSpots;



    public NearestParkingSpotStrategy(List<ParkingSpot> spots) {
        nearestSpots = new PriorityQueue<>(Comparator
                .comparing((ParkingSpot spot) -> spot.getStatus() == ParkingSpotStatus.FREE? 0:1)
                .thenComparingDouble(ParkingSpot::getDistanceFromEntrance));

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
        Iterator<ParkingSpot> iterator = nearestSpots.iterator();
        while(iterator.hasNext()){
            ParkingSpot spot = iterator.next();
            if(spot.getStatus() == ParkingSpotStatus.FREE && spot.getType()  == type){
                iterator.remove();
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
