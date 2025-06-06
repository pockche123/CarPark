package org.example;

import java.util.HashMap;
import java.util.Map;

public class CarRegistry {
    protected Map<String, Car> carRegistry;

    public CarRegistry(Map<String, Car> registry){
        this.carRegistry = registry;
    }


    public boolean addCar(String key, Car value){
        carRegistry.put(key, value);
        return carRegistry.containsKey(key);
    }

    public boolean removeCar(String key){
        carRegistry.remove(key);
        return !carRegistry.containsKey(key);
    }



}
