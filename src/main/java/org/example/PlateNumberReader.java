package org.example;

public class PlateNumberReader extends IDReader{
    @Override
    public String read(Car car) {
        return car.getPlate();
    }
}
