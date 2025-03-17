package org.example;

public class Car {

    private String plate;
    private String barcode;

    public Car(String plate, String barcode){
        this.plate = plate;
        this.barcode = barcode;

    }
    public String getPlate(){return this.plate};

    public String getBarcode(){
        return this.barcode;
    }

}
