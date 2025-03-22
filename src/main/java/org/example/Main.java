package org.example;

import org.example.builder.CarParkDirector;
import org.example.menu.CarParkMenu;


public class Main {
    public static void main(String[] args) throws InterruptedException {
      CarParkManager carParkManager = new CarParkManager();
      CarParkDirector director = new CarParkDirector();
      CarPark park = director.buildAverageCarPark(100);

//      park.printCarParkSpots();

      CarParkMenu menu = new CarParkMenu();
      menu.start();

//      int val = carParkManager.checkForSpaces(park, "NORMAL");
//        System.out.println(val);
//      carParkManager.enterCarPark();
//
//        CarParkMenu menu = new CarParkMenu();
//        menu.showMenu();





    }
}