package org.example;

import org.example.builder.CarParkDirector;
import org.example.parkingspots.ParkingSpotType;


import java.util.Map;


public class Main {
    public static void main(String[] args) {
      CarParkManager carParkManager = new CarParkManager();
      CarParkDirector director = new CarParkDirector();
      CarPark park = director.buildAverageCarPark(100);

      CarParkMenu menu = new CarParkMenu();
      menu.showMenu();

//      int val = carParkManager.checkForSpaces(park, "NORMAL");
//        System.out.println(val);
//      carParkManager.enterCarPark();
//
//        CarParkMenu menu = new CarParkMenu();
//        menu.showMenu();





    }
}