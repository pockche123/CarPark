package org.example;



import java.time.LocalDateTime;

public class Car {

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
    }

    public LocalDateTime getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(LocalDateTime enterTime) {
        this.enterTime = enterTime;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }



}
