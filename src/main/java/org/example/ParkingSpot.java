package org.example;

public class ParkingSpot {
    private int spotId;
    private SpotType type;
    private double distanceFromEntrance;
    private ParkingSpotStatus status;

    private boolean taken = false;
    public ParkingSpot(int id, SpotType type, double distance){
        this.spotId = id;
        this.type = type;
        this.distanceFromEntrance = distance;
        this.status = ParkingSpotStatus.FREE;
    }

    public ParkingSpotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSpotStatus status) {
        this.status = status;
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


    public String toString() {
        return "ParkingSpot{" +
                "spotId=" + spotId +
                ", type=" + type +
                ", distanceFromEntrance=" + distanceFromEntrance +
                ", status=" + status +
                ", taken=" + taken +
                '}';
    }

}
