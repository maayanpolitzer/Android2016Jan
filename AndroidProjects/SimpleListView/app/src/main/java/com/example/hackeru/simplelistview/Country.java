package com.example.hackeru.simplelistview;

/**
 * Created by hackeru on 01/05/2016.
 */
public class Country {

    private String name;
    private int image;

    public Country(String name, int image){
        this.name = name;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
