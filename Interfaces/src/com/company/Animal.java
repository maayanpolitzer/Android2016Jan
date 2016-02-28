package com.company;

/**
 * Created by hackeru on 28/02/2016.
 */
public abstract class Animal implements Eat {
    @Override
    public void eat() {

    }

    @Override
    public void drink() {

    }

    public void sayHi(){
        System.out.println("hi from animal");
    }
}
