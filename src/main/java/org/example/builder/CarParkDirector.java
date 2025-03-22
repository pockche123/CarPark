package org.example.builder;

import org.example.CarPark;
import org.example.ParkingSpot;
import org.example.ParkingSpotType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarParkDirector{

    public CarPark buildAverageCarPark(int capacity){
        CarPark carPark = new CarPark(capacity);


        int electricSpaces = (int) (0.05 * capacity);
        int handicappedSpaces = (int) (0.05 * capacity);
        int normalSpaces = capacity - electricSpaces - handicappedSpaces;

        List<ParkingSpot> spots = new ArrayList<>();
        double distance = 2.0;
        int times = 0;
        for(int i=0; i<capacity; i++){
            spots.add(new ParkingSpot(i+1, distance));
            times +=1;
            if(times == 2){
                distance += 1;
                times = 0;
            }
        }

        for(int i=0; i<handicappedSpaces; i++){
            ParkingSpot spot = spots.get(i);
            spot.setType(ParkingSpotType.ACCESSIBLE);
        }

        for(int i=electricSpaces; i< electricSpaces + normalSpaces/2; i++){
            ParkingSpot spot = spots.get(i);
            spot.setType(ParkingSpotType.STANDARD);
        }
        int aStart = electricSpaces + normalSpaces/2;

        for(int i= aStart; i< aStart + electricSpaces; i++){
            ParkingSpot spot = spots.get(i);
            spot.setType(ParkingSpotType.ELECTRIC);
        }

        int nStart = aStart + electricSpaces;
        int nEnd = capacity %2 == 0? nStart + normalSpaces/2 : nStart + normalSpaces/2 + 1;

        for(int i=nStart; i< nEnd; i++){
            ParkingSpot spot = spots.get(i);
            spot.setType(ParkingSpotType.STANDARD);
        }

        carPark.setParkingSpots(spots);
        carPark.setSpotCount();

        carPark.getParkingSpots().forEach(System.out::println);

        return carPark;
    }


}
