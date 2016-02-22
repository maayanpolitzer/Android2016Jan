package com.company;

import java.util.ArrayList;

/**
 * Created by hackeru on 21/02/2016.
 */
public class Order {

    private ArrayList<MenuItem> items;
    private String name;

    public Order(){
        items = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name + "," + items;

    }

    public void addItem(MenuItem item){
        items.add(item);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }
}
