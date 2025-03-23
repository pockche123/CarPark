package org.example;



public class ExitBarrier implements Barrier{
    private boolean up;
    private Ticket ticket;

    public ExitBarrier(ParkingSpot spot){
        ticket = new Ticket(spot);
    }

    public boolean getUp() {
        return up;
    }

    @Override
    public void raise() {
        if(ticket != null) {
            System.out.println("Exit barrier raised");
            this.up = true;
        }
        System.out.println("Exit barrier cannot be raised");
    }

    @Override
    public void lower() {
        this.up = false;
    }
}
