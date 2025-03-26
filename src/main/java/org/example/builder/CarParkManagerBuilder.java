package org.example.builder;

import org.example.*;
import org.example.parkingstrategy.NearestParkingSpotStrategy;
import org.example.parkingstrategy.OrderedParkingSpotStrategy;

import java.io.IOException;

public class CarParkManagerBuilder {

    private CarRegistry registry;
    private MemberCarRegistry memberCarRegistry;
    private EntryBarrier entryBarrier;
    private NearestParkingSpotStrategy nearestStrategy;
    private OrderedParkingSpotStrategy firstStrategy;
    private FullSign fullSign;
    private BarcodeReader barcodeReader;
    private PlateNumberReader plateNumberReader;
    private CarPark<Car> carPark;


    public CarParkManagerBuilder setRegistry(CarRegistry registry) {
        this.registry = registry;
        return this;
    }

    public CarParkManagerBuilder setMemberCarRegistry(MemberCarRegistry memberCarRegistry) {
        this.memberCarRegistry = memberCarRegistry;
        return this;
    }

    public CarParkManagerBuilder setEntryBarrier(EntryBarrier entryBarrier) {
        this.entryBarrier = entryBarrier;
        return this;
    }

    public CarParkManagerBuilder setNearestStrategy(NearestParkingSpotStrategy nearestStrategy) {
        this.nearestStrategy = nearestStrategy;
        return this;
    }

    public CarParkManagerBuilder setFirstStrategy(OrderedParkingSpotStrategy firstStrategy) {
        this.firstStrategy = firstStrategy;
        return this;
    }

    public CarParkManagerBuilder setFullSign(FullSign fullSign) {
        this.fullSign = fullSign;
        return this;
    }

    public CarParkManagerBuilder setBarcodeReader(BarcodeReader barcodeReader) {
        this.barcodeReader = barcodeReader;
        return this;
    }

    public CarParkManagerBuilder setPlateNumberReader(PlateNumberReader plateNumberReader) {
        this.plateNumberReader = plateNumberReader;
        return this;
    }

    public CarParkManagerBuilder setCarPark(CarPark<Car> carPark) {
        this.carPark = carPark;
        return this;
    }

    // Build the CarParkManager instance
    public CarParkManager build() throws IOException{
        CarParkManager carParkManager = new CarParkManager();

        // Set each field to the CarParkManager instance
        carParkManager.setRegistry(registry);
        carParkManager.setMemberCarRegistry(memberCarRegistry);
        carParkManager.setEntryBarrier(entryBarrier);
        carParkManager.setNearestStrategy(nearestStrategy);
        carParkManager.setFirstStrategy(firstStrategy);
        carParkManager.setFullSign(fullSign);
        carParkManager.setBarcodeReader(barcodeReader);
        carParkManager.setPlateNumberReader(plateNumberReader);
        carParkManager.setCarPark(carPark);

        return carParkManager;
    }
}
