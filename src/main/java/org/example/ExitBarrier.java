package org.example;

public class ExitBarrier implements Barrier{
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
