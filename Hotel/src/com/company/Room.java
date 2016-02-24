package com.company;

/**
 * Created by hackeru on 24/02/2016.
 */
public class Room {

    private int roomNumber;
    private static int counter = 0;
    private String type = "regular room";
    private boolean occupied;   // false or true
    private int price;

    public Room(){
        roomNumber = ++counter;
    }

    public void saveRoom(){
        refillMiniBar();
        occupied = true;
    }

    private void refillMiniBar(){
        // send sms to cleaning manager to refill the minibar
        System.out.println("miniBar is ready!!!");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {

        this.occupied = occupied;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
