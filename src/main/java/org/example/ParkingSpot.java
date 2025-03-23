package org.example;

public class ParkingSpot {
    private int spotId;
    private ParkingSpotType type;
    private double distanceFromEntrance;
    private ParkingSpotStatus status;


    public ParkingSpot(int id, double distance){
        this.spotId = id;
        this.distanceFromEntrance = distance;
        this.status = ParkingSpotStatus.FREE;
    }

    public ParkingSpot(int id, ParkingSpotType type, double distance){
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


    public double getDistanceFromEntrance() {
        return distanceFromEntrance;
    }

    public void setDistanceFromEntrance(double distanceFromEntrance) {
        this.distanceFromEntrance = distanceFromEntrance;
    }



    public ParkingSpotType getType() {
        return type;
    }

    public void setType(ParkingSpotType type) {
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
                '}';
    }

}
