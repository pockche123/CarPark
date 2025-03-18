package org.example;

import org.example.builder.CarParkDirector;
import org.example.parkingspots.ParkingSpotType;


import java.util.Map;


public class Main {
    public static void main(String[] args) {
        CarParkDirector director = new CarParkDirector();

        CarPark carPark = director.buildAverageCarPark(120);

        Map<String, ParkingSpotType> map = carPark.getParkingSpotTypeSpacesMap();

        for(ParkingSpotType type: map.values()){
            System.out.println();
            type.printAvailableSpots();
            System.out.println();
        }







    }
}