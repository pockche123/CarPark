package org.example;

public class EntryBarrier implements Barrier{
    private boolean up;

    @Override
    public void raise() {
        this.up = true;
    }

    @Override
    public void lower() {
        this.up = false;
    }
}
