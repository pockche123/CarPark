package org.example.parkingstrategy;

import org.example.ParkingSpot;
import org.example.ParkingSpotStatus;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class FirstAvailableParkingSpotStrategy implements ParkingSpotStrategy{
    private final TreeSet<ParkingSpot> availableSpots;

    public FirstAvailableParkingSpotStrategy(List<ParkingSpot> spots){
        availableSpots = new TreeSet<>(Comparator.comparingInt(ParkingSpot::getSpotId));
        availableSpots.addAll(spots);
    }
    @Override
    public ParkingSpot findNearestSpot() {
        if(availableSpots.isEmpty()){
            return null;
        }
        return availableSpots.first();
    }

    @Override
    public ParkingSpot parkCar() {
        if(!availableSpots.isEmpty()) {
            ParkingSpot spot = availableSpots.pollFirst();
            spot.setStatus(ParkingSpotStatus.OCCUPIED);
            return availableSpots.pollFirst();
        } else{
            return null;
        }
    }

    @Override
    public void leaveSpot(ParkingSpot spot) {
        spot.setStatus(ParkingSpotStatus.FREE);
        availableSpots.add(spot);
    }



}
