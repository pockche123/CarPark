package org.example;



public class Car {

    private String plate;
    private String barcode;
    private boolean requiresHandicapped  = false;
    private boolean hasPaid = false;

    public Car(String plate, String barcode, boolean requiresHandicapped){
        this.plate = plate;
        this.barcode = barcode;
        this.requiresHandicapped = requiresHandicapped;
    }

    public String getBarcode(){
        return this.barcode;
    }

    public void setHasPaid(boolean paid){
        this.hasPaid = paid;
    }

    public boolean getHasPaid(){
        return this.hasPaid;
    }
}
