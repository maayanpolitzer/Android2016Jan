package com.company;

public class Car {

    private int year;
    private String brand;
    private String color;
    private static int counter = 0;

    public Car(int newYear, String newBrand, String newColor){
        year = newYear;
        brand = newBrand;
        color = newColor;
        counter++;
    }

    public int getYear(){
        return year;
    }

    public String getColor(){
        return color;
    }

    public static int getCounter(){
        return counter;
    }

}
