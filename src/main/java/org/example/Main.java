package org.example;

import org.example.builder.CarParkDirector;
import org.example.database.ParkingSpotLoader;
import org.example.menu.CarParkMenu;
import org.example.menu.CarParkView;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        CarParkDirector director = new CarParkDirector();
        PlateNumberReader plateReader = new PlateNumberReader();
        MemberCarRegistry memberCarRegistry = new MemberCarRegistry();
        BarcodeReader barcodeReader = new BarcodeReader();
        CarRegistry carRegistry = new CarRegistry();

        CarParkManager carParkManager = new CarParkManager(director, plateReader,
                memberCarRegistry, barcodeReader,
                carRegistry);
        CarParkView parkView = new CarParkView();
        CarParkMenu menu = new CarParkMenu(carParkManager, parkView);
        menu.start();

    }
}