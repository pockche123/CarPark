package org.example;

import org.example.parkingspots.ParkingSpotType;

public class EntryBarrier implements Barrier {
    private boolean up;
    private Ticket ticket;






    @Override
    public void raise() {
        this.up = true;
    }

    @Override
    public void lower() {
        this.up = false;
    }
}
