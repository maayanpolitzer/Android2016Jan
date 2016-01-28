package com.company;

import java.util.Random;

public class Car {

    private int year;
    private String brand;
    private String color;
    private int previousOwners;
    private Person owner;
    private int licensePlate;
    private final int THIS_YEAR = 2016;

    private static int carsCreated = 0;

    public Car(String newBrand, String newColor, Person newOwner){
        year = THIS_YEAR;
        brand = newBrand;
        color = newColor;
        carsCreated++;
        owner = newOwner;
        licensePlate = generateLicense();
        previousOwners++;
    }

    private int generateLicense() {
        Random r = new Random();
        return 1000000 + r.nextInt(9000000);
    }

    public boolean buyCar(Person buyer){
        if(owner == buyer){
            return false;
        }
        owner = buyer;
        previousOwners++;
        return true;
    }


    @Override
    public String toString() {
        String s = "year: " + year + ", brand: " + brand + ", color: "
                + color + ", license: " + licensePlate + ", owner: " + owner + ", HAND: " + previousOwners;
        return s;
    }

    public int getYear(){
        return year;
    }

    public String getColor(){
        return color;
    }

    public static int getCarsCreated(){
        return carsCreated;
    }

    public Person getOwner(){
        return owner;
    }

}
