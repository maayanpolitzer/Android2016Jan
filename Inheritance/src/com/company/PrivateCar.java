package com.company;

/**
 * Created by hackeru on 07/02/2016.
 */
public class PrivateCar extends Vehicle {

    public PrivateCar(int numOfDoors){
        super(4, numOfDoors);
    }

    @Override
    public void go() {
        System.out.println("3 m");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
