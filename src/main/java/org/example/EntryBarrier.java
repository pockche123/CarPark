package org.example;

import org.example.parkingspots.ParkingSpotType;

public class EntryBarrier implements Barrier {

    private boolean up;
    private Ticket ticket;

    public EntryBarrier(ParkingSpotType spotType){
        ticket = new Ticket(spotType);
    }


    public boolean getUp() {
        return up;
    }


    @Override
    public void raise() {
        if(ticket != null) {
            System.out.println("Entry barrier raised");
            this.up = true;
        }
        System.out.println("Entry barrier cannot be raised");
    }

    @Override
    public void lower() {
        this.up = false;
    }
}
