package com.company;

/**
 * Created by hackeru on 10/02/2016.
 */
public class Fruit {

    private String name;
    private double price;

    public Fruit(String name, double price) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "," + price;
    }
}
