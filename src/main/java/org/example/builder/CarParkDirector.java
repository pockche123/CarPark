package org.example.builder;

import org.example.CarPark;
import org.example.parkingspots.ElectricVehicleSpotType;
import org.example.parkingspots.HandiCappedSpotType;
import org.example.parkingspots.NormalSpotType;
import org.example.parkingspots.ParkingSpotType;
import org.example.parkingstrategy.FirstAvailableParkingSpotStrategy;
import org.example.parkingstrategy.NearestParkingSpotStrategy;
import org.example.parkingstrategy.ParkingSpotStrategy;

import java.util.HashMap;
import java.util.Map;

public class CarParkDirector{

    public CarPark buildAverageCarPark(int capacity){
        CarPark carPark = new CarPark(capacity);

        Map<ParkingSpotType, Integer> parkingSpotTypeMap = new HashMap<>();

        int electricSpaces = (int) (0.05 * capacity);
        int handicappedSpaces = (int) (0.05 * capacity);
        int normalSpaces = capacity - electricSpaces - handicappedSpaces;

        ParkingSpotStrategy nearestStrategy = new NearestParkingSpotStrategy(1,normalSpaces/2);
        ParkingSpotType normal1  = new NormalSpotType(nearestStrategy);


        int start1 = normalSpaces/2 + 1;
        int end1 = normalSpaces/2 + electricSpaces;
        ParkingSpotStrategy firstAvailableStrategy = new FirstAvailableParkingSpotStrategy(start1, end1);
        ParkingSpotType electric = new ElectricVehicleSpotType(firstAvailableStrategy);


        int start2 = end1 + 1;
        int end2 = end1 + handicappedSpaces;
        firstAvailableStrategy = new FirstAvailableParkingSpotStrategy(start2,end2);
        ParkingSpotType handicapped = new HandiCappedSpotType(firstAvailableStrategy);


        int start3 = end2 + 1;
        int end3 = capacity %2 == 0 ? end2 + normalSpaces/2  : end2 + normalSpaces/2 + 1;
        nearestStrategy = new NearestParkingSpotStrategy(start3,end3);
        ParkingSpotType normal2 = new NormalSpotType(nearestStrategy);

        parkingSpotTypeMap.put(normal1, normalSpaces/2);
        parkingSpotTypeMap.put(electric, electricSpaces);
        parkingSpotTypeMap.put(handicapped, handicappedSpaces);
        parkingSpotTypeMap.put(normal2, normalSpaces/2);

        carPark.setParkingSpotTypeSpacesMap(parkingSpotTypeMap);

        return carPark;
    }


}
