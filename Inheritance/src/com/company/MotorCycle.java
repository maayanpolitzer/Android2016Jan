package com.company;

/**
 * Created by hackeru on 07/02/2016.
 */
public class MotorCycle extends Vehicle {

    public MotorCycle(){
        super(2,0);
    }

    @Override
    public void go() {
        System.out.println("10 m");

    }
}
