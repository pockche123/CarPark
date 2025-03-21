package org.example;


public class Sensor {
    private Car car;

    public Sensor(){};

    public Sensor(Car car){
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isCarPresent(){
        return car != null;
    }

}
