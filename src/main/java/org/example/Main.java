package org.example;

import org.example.builder.CarParkDirector;
import org.example.parkingspots.ParkingSpotType;


import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CarParkDirector director = new CarParkDirector();

        CarPark carPark = director.buildAverageCarPark(100);

        Map<String, ParkingSpotType> map = carPark.getParkingSpotTypeSpacesMap();

        for(ParkingSpotType type: map.values()){
            System.out.println();
            type.printAvailableSpots();
            System.out.println();
        }






    }
}