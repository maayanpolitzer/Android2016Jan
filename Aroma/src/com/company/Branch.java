package com.company;

import java.util.ArrayList;

/**
 * Created by hackeru on 21/02/2016.
 */
public class Branch {

    private boolean open;
    private ArrayList<Order> orders;

    public Branch(){
        orders = new ArrayList<>();
        open = true;
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public boolean isOpen() {
        return open;
    }

    public void close() {
        open = false;
    }
}
