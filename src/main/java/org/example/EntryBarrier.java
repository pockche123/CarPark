package org.example;


public class EntryBarrier implements Barrier {

    private boolean up;
    public EntryBarrier(){}

    public boolean getUp() {
        return up;
    }


    @Override
    public void raise() {
            System.out.println("Entry barrier raised");
            this.up = true;
    }

    @Override
    public void lower() {
        System.out.println("Entry barrier lowered");
        this.up = false;
    }
}
