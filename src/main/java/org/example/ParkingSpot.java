package org.example;

public class ParkingSpot<T> {
    private T spotType;
    public ParkingSpot(T spotType){
        this.spotType = spotType;
    }

    public T getSpotType(){
        return spotType;
    }

}
