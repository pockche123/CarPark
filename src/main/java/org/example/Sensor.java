package org.example;


public class Sensor {
    private Car car;

    public Sensor(Car car){
        this.car = car;
    }

    public boolean isCarPresent(){
        return car != null;
    }

}
