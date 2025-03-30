package org.example.builder;

import org.example.*;
import org.example.parkingstrategy.NearestParkingSpotStrategy;
import org.example.parkingstrategy.OrderedParkingSpotStrategy;

import java.io.IOException;

public class CarParkManagerBuilder {

    private CarRegistry registry;
    private MemberCarRegistry memberCarRegistry;
    private NearestParkingSpotStrategy nearestStrategy;
    private OrderedParkingSpotStrategy firstStrategy;
    private CarPark<Car> carPark;


    public CarParkManagerBuilder setRegistry(CarRegistry registry) {
        this.registry = registry;
        return this;
    }

    public CarParkManagerBuilder setMemberCarRegistry(MemberCarRegistry memberCarRegistry) {
        this.memberCarRegistry = memberCarRegistry;
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


    public CarParkManagerBuilder setCarPark(CarPark<Car> carPark) {
        this.carPark = carPark;
        return this;
    }


    public CarParkManager build() throws IOException{
        CarParkManager carParkManager = new CarParkManager();

        carParkManager.setRegistry(registry);
        carParkManager.setMemberCarRegistry(memberCarRegistry);
        carParkManager.setNearestStrategy(nearestStrategy);
        carParkManager.setFirstStrategy(firstStrategy);
        carParkManager.setCarPark(carPark);

        return carParkManager;
    }
}
