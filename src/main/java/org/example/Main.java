package org.example;

import org.example.builder.CarParkDirector;
import org.example.menu.CarParkMenu;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        CarParkDirector director = new CarParkDirector();
        CarParkManager carParkManager = director.buildPreMadeCarParkWithManager();
        CarParkMenu menu = new CarParkMenu(carParkManager);
        menu.start();


    }
}