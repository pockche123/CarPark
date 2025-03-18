package org.example;

import org.example.builder.CarParkDirector;

import java.util.Scanner;

public class CarParkManager {

    private static Scanner stdin = new Scanner(System.in);

    private CarParkDirector director;


//    private Barrier barrier;
//    private Sensor sensor;
//    private IDReader idreader;
//    private FullSign fullSign;
//    private CarRegistry carRegistry;

    public CarParkManager(){}



    public void enterCarPark()
    {
//        car enter the car park
        Car car = new Car("UJZ8884");
//        sensor detects the car
        Sensor sensor = new Sensor(car);

//        car selects the parkingspot - if no parkingspot exits else
        System.out.println("Please select a parking spot option (1-3)");
        System.out.println("1. Standard");
        System.out.println("2. Electric Vehicle");
        System.out.println("3. Handicap");
        int option = Integer.parseInt(stdin.nextLine());




//        entry barrier opens
//        car is registered into the registry
//        sensor doesn't detect a car
//        entry barrier closes

    }



//    public boolean checkValidOption(String option){
//        boolean numeric = false;
//        try{
//            int num = Integer.parseInt(option);
//        } catch(NumberFormatException e){
//
//        }
//
//
//    }

    public void parkInASpot(){

    }

    public void leaveTheSpot(){

    }

    public void  exitCarPark(){
//        A ticket is generated for the car
    }






}
