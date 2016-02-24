package com.company;

public class Main {

    public static void main(String[] args) {

        Hotel h = new Hotel(12,5,2);
        h.orderRoom("twin");
        h.orderRoom("twin");
        System.out.println(h.getSingleBed());
        System.out.println(h.getDoubleBed());
        System.out.println(h.occupiedRatio());  // "68%";
        h.saveDataToFile();

    }
}
