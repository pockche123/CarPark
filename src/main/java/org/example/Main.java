package org.example;

import org.example.builder.CarParkDirector;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CarParkDirector director = new CarParkDirector();

        CarPark carPark = director.buildAverageCarPark(100);

        carPark.get


    }
}