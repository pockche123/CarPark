package org.example;

import org.example.builder.CarParkDirector;
import org.example.database.ParkingSpotLoader;
import org.example.menu.CarParkMenu;
import org.example.menu.CarParkView;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
//      CarParkManager carParkManager = new CarParkManager();
//      CarParkDirector director = new CarParkDirector();
//      CarPark park = director.buildAverageCarPark(100);




//      park.printCarParkSpots();
        // Instantiate the real implementations of the classes
        CarParkDirector director = new CarParkDirector();
        PlateNumberReader plateReader = new PlateNumberReader();
        MemberCarRegistry memberCarRegistry = new MemberCarRegistry();
        BarcodeReader barcodeReader = new BarcodeReader();
        CarRegistry carRegistry = new CarRegistry();

        // Create the CarParkManager instance using the instantiated objects
        CarParkManager carParkManager = new CarParkManager(director, plateReader,
                memberCarRegistry, barcodeReader,
                carRegistry);

        CarParkView parkView = new CarParkView();
      CarParkMenu menu = new CarParkMenu(carParkManager, parkView);
      menu.start();

//        ParkingSpotLoader spotLoader = new ParkingSpotLoader();
//
//        List<ParkingSpot> parkingspots = spotLoader.loadParkingSpotsFromJson();
//        parkingspots.forEach(System.out::println);




    }
}