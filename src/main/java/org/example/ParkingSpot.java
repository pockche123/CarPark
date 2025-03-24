package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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

//    public ParkingSpot(int id, ParkingSpotType type, double distanceFromEntrance, ParkingSpotStatus status){
//        this.spotId = id;
//        this.type = type;
//        this.distanceFromEntrance = distanceFromEntrance;
//        this.status = status;
//    }
@JsonCreator
public ParkingSpot(
        @JsonProperty("id") int spotId,
        @JsonProperty("type") ParkingSpotType type,
        @JsonProperty("distanceFromEntrance") double distanceFromEntrance,
        @JsonProperty("status") ParkingSpotStatus status
) {   this.spotId = spotId;
    this.type = type;
    this.distanceFromEntrance = distanceFromEntrance;
    this.status = status;
};

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
