package org.example.parkingstrategy;

import org.example.ParkingSpot;
import org.example.ParkingSpotStatus;
import org.example.ParkingSpotType;

import java.util.*;

public class FirstAvailableParkingSpotStrategy implements ParkingSpotStrategy{
    private final TreeSet<ParkingSpot> availableSpots;



    public FirstAvailableParkingSpotStrategy(List<ParkingSpot> spots){
        availableSpots = new TreeSet<>(Comparator
                .comparing((ParkingSpot spot) -> spot.getStatus() == ParkingSpotStatus.FREE ? 0:1)
                .thenComparing(ParkingSpot::getSpotId)
        );

        availableSpots.addAll(spots);
    }
    @Override
    public ParkingSpot findSpot(ParkingSpotType type) {
        for(ParkingSpot spot: availableSpots){
            if(spot.getStatus() == ParkingSpotStatus.FREE && spot.getType() == type ){
                return spot;
            }
        }
        return null;
    }

    @Override
    public ParkingSpot parkCar(ParkingSpotType type) {
        Iterator<ParkingSpot> iterator = availableSpots.iterator();
        while(iterator.hasNext()){
            ParkingSpot spot = iterator.next();
            if(spot.getStatus() == ParkingSpotStatus.FREE && findSpot().getType()  == type){
                iterator.remove();
                spot.setStatus(ParkingSpotStatus.OCCUPIED);
                availableSpots.add(spot);
                return spot;
            }
        }
        return null;
    }

    @Override
    public void leaveSpot(ParkingSpot spot) {
        availableSpots.remove(spot);
        spot.setStatus(ParkingSpotStatus.FREE);
        availableSpots.add(spot);
    }




}
