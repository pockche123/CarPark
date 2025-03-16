package org.example;

public class BarcodeReader extends IDReader{


    @Override
    public String read(Car car) {
        return car.getBarcode();
    }
}
