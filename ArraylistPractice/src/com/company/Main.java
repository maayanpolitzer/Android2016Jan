package com.company;

import java.util.ArrayList;

public class Main {

    static ArrayList<Fruit> fruits;
    static final double VAT = 17;

    public static void main(String[] args) {
        /*
        ArrayList<Integer> list = new ArrayList<>();
        list.add(46);
        list.add(-890);
        //System.out.println(list.get(1));
        //System.out.println(list.indexOf(47));
        System.out.println(list.size());
        */
        fruits = new ArrayList<>();
        fruits.add(new Fruit("apple", 10));
        fruits.add(new Fruit("banana", 9.9));
        fruits.add(new Fruit("melon", 6.9));
        //System.out.println(fruits);
        addVAT();
        System.out.println(fruits);

    }

    public static void addVAT(){
        for (int i = 0; i < fruits.size(); i++){
            double oldPrice = fruits.get(i).getPrice();
            fruits.get(i).setPrice(oldPrice * (1 + VAT / 100 ));
        }
    }

}
