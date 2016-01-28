package com.company;


import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Person p1 = new Person("moshe");
        Person p2 = new Person("maayan");
        Person p3 = new Person("yosi");

        Car c1 = new Car("BMW", "pink", p1);

        System.out.println(c1);
        c1.buyCar(p2);
        System.out.println(c1);
        c1.buyCar(p2);
        System.out.println(c1);


    }
}
