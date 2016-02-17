package com.company;

/**
 * Created by maayanpolitzer on 13/02/2016.
 */
public abstract class Animal {

    private String name;
    private Owner owner;

    public Animal(String name, Owner owner){
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }
}
