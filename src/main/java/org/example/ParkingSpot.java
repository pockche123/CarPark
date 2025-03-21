package org.example;

import org.example.parkingspots.ParkingSpotType;

import java.util.PriorityQueue;

public class ParkingSpot {
    private int spotId;
    private SpotType type;
    private double distanceFromEntrance;

    private boolean taken = false;
    public ParkingSpot(int id, SpotType type, double distance){
        this.spotId = id;
        this.type = type;
        this.distanceFromEntrance = distance
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public double getDistanceFromEntrance() {
        return distanceFromEntrance;
    }

    public void setDistanceFromEntrance(double distanceFromEntrance) {
        this.distanceFromEntrance = distanceFromEntrance;
    }

    public boolean isTaken() {
        return taken;
    }

    public SpotType getType() {
        return type;
    }

    public void setType(SpotType type) {
        this.type = type;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

}
