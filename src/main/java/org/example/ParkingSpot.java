package org.example;

import org.example.parkingspots.ParkingSpotType;

import java.util.PriorityQueue;

public class ParkingSpot {
    private int spotId;
    private ParkingSpotType spotType;
    private boolean taken = false;
    public ParkingSpot(ParkingSpotType spotType){
        this.spotType = spotType;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public ParkingSpotType getSpotType(){
        return spotType;
    }
}
