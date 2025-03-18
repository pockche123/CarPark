package org.example.parkingspots;


import org.example.parkingstrategy.ParkingSpotStrategy;

public class ElectricVehicleSpotType extends ParkingSpotType {
    private ParkingSpotStrategy parkingSpotStrategy;

    public ElectricVehicleSpotType(ParkingSpotStrategy parkingSpotStrategy){
        this.parkingSpotStrategy = parkingSpotStrategy;
    }

    @Override
    public Integer findSpot() {
        return parkingSpotStrategy.findNearestSpot();
    }

    @Override
    public Integer parkCar() {
        return parkingSpotStrategy.parkCar();
    }

    @Override
    public void leaveSpot(int spot) {
        parkingSpotStrategy.leaveSpot(spot);
    }

    @Override
    public void printAvailableSpots() {
        parkingSpotStrategy.printAvailableSpots();
    }

    @Override
    public int getSpacesLeft() {
        return parkingSpotStrategy.getSpacesLeft();
    }
}
