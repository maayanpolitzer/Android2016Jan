package com.company;

/**
 * Created by hackeru on 17/02/2016.
 */
public abstract class Animal {

    private String name;

    public Animal(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
