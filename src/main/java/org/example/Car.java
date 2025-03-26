package org.example;



import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;
import java.time.LocalDateTime;

public class Car implements Vehicle{

    private String plate;
    private String barcode;
    private LocalDateTime enterTime;
    private LocalDateTime leaveTime;
    private Ticket ticket;


    public Car(){

    }

    public Car(String plate){
        this.plate = plate;

    }
    public Car(long barcode){
        this.barcode = String.valueOf(barcode);
    }
    public String getPlate(){return this.plate;}

    public String getBarcode(){
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }



    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public LocalDateTime getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(LocalDateTime leaveTime) {
        this.leaveTime = leaveTime;
        System.out.println("The vehicle has left at " + leaveTime);
        System.out.println("Going forward, tickets will be issued based on entry to exit time automatically.");
    }

    public LocalDateTime getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(LocalDateTime enterTime) {

        this.enterTime = enterTime;
        System.out.println("Vehicle has entered at " + enterTime);
        System.out.println("If the vehicle is parked for under 5 minutes, no payment is necessary.");
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }



}
