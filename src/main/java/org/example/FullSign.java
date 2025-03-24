package org.example;

public class FullSign {
    private boolean lightOn;


    public void switchOn(){
        System.out.println("'Full' Sign is up");
        this.lightOn = true;
    }

    public void switchOff(){
        System.out.println("'Full' Sign is off");
        this.lightOn = false;
    }
}
