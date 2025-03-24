package org.example;

import org.example.builder.CarParkDirector;
import org.example.database.ParkingSpotLoader;
import org.example.menu.CarParkMenu;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
//      CarParkManager carParkManager = new CarParkManager();
//      CarParkDirector director = new CarParkDirector();
//      CarPark park = director.buildAverageCarPark(100);




//      park.printCarParkSpots();

//      CarParkMenu menu = new CarParkMenu();
//      menu.start();

        ParkingSpotLoader spotLoader = new ParkingSpotLoader();

        List<ParkingSpot> parkingspots = spotLoader.loadParkingSpotsFromJson();
        parkingspots.forEach(System.out::println);




    }
}