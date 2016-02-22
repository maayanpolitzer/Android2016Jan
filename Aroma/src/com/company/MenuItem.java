package com.company;

/**
 * Created by hackeru on 21/02/2016.
 */
public class MenuItem {

    private String name;
    private double price;
    private int time;

    public MenuItem(String name, double price, int time){
        this.name = name;
        this.price = price;
        this.time = time;
    }

    @Override
    public String toString() {
        return name;
    }
}
