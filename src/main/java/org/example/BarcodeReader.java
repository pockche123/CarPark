package org.example;

// didn't use this. gotta use this
public class BarcodeReader extends IDReader{


    @Override
    public String read(Car car) {
        return car.getBarcode();
    }
}
