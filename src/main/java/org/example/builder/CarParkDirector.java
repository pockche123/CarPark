package org.example.builder;

import org.example.*;
import org.example.database.ParkingSpotLoader;
import org.example.parkingstrategy.NearestParkingSpotStrategy;
import org.example.parkingstrategy.OrderedParkingSpotStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarParkDirector{

    public CarPark<Vehicle> buildAverageCarPark(int capacity){
        CarPark<Vehicle> carPark = new CarPark<>(capacity);


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
        carPark.setEntryBarrier(new EntryBarrier());
        carPark.setExitBarrier(new ExitBarrier(null));
        carPark.setEntrySensor(new Sensor());
        carPark.setExitSensor(new Sensor());
        return carPark;
    }



    public CarPark<Car> buildPreMadeCarPark() throws IOException {
        CarPark<Car> park = new CarPark<>();
        ParkingSpotLoader spotLoader = new ParkingSpotLoader();
        List<ParkingSpot> parkingSpots = spotLoader.loadParkingSpotsFromJson();
        park.setParkingSpots(parkingSpots);
        park.setCapacity(parkingSpots.size());
        park.setSpotCount();
        park.setEntryBarrier(new EntryBarrier());
        park.setExitBarrier(new ExitBarrier(null));
        park.setEntrySensor(new Sensor());
        park.setExitSensor(new Sensor());
        park.setEntryBarrier(new EntryBarrier());
        park.setExitBarrier(new ExitBarrier(null));
        park.setEntrySensor(new Sensor());
        park.setExitSensor(new Sensor());
        park.setFullSign(new FullSign());
        park.setBarcodeReader(new BarcodeReader());
        park.setPlateNumberReader(new PlateNumberReader());
        return park;
    }

    public CarParkManager buildPreMadeCarParkWithManager() throws IOException {

        CarPark<Car> carPark = buildPreMadeCarPark();
        Map<String, Car> registry = new HashMap<>();
        Map<String, Car> memberRegistry = new HashMap<>();

        CarParkManager carParkManager = new CarParkManagerBuilder()
                .setRegistry(new CarRegistry(registry))
                .setMemberCarRegistry(new MemberCarRegistry(memberRegistry))
                .setNearestStrategy(new NearestParkingSpotStrategy(carPark.getParkingSpots()))
                .setFirstStrategy(new OrderedParkingSpotStrategy(carPark.getParkingSpots()))
                .setCarPark(carPark)
                .build();

        return carParkManager;
    }


}
