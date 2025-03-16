package org.example;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {

    private String plate;
    private String barcode;
    private boolean requiresHandicapped  = false;

    public Car(String plate, String barcode, boolean requiresHandicapped){
        this.plate = plate;
        this.barcode = barcode;
        this.requiresHandicapped = requiresHandicapped;
    }
}
