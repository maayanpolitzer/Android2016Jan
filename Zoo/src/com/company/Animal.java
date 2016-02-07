package com.company;


public class Animal {

    private String name;
    private boolean aquatic;

    public Animal(String name, boolean isAquatic){
        this.name = name;
        aquatic = isAquatic;
    }



    public String getName(){
        return name;
    }

    public boolean isAquatic(){
        return aquatic;
    }

    @Override
    public String toString() {
        return name + ", lives in water? " + aquatic;
    }
}
