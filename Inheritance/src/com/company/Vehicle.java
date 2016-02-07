package com.company;

public abstract class Vehicle {

    private int numOfWheels;
    private int numOfDoors;

    public Vehicle(int numOfWheels, int numOfDoors){
        this.numOfWheels = numOfWheels;
        this.numOfDoors = numOfDoors;
    }

    public void go(){
        System.out.println("5 m");
    }

    @Override
    public String toString() {
        return "Vehicle";
    }
}
