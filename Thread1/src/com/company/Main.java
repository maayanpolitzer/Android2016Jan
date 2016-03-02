package com.company;

public class Main {

    public static void main(String[] args) {

        /*
        3 ways:
        1. create object from a class that extend Thread class.

        KevinNumber2 kevin = new KevinNumber2();
        kevin.start();
        System.out.println("From main Thread");
        */
        /*
        2. create object from a Thread class pass object that implement Runnable interface as parameter  .
        Moshe m = new Moshe();
        Thread t = new Thread(m);
        t.start();
        */
        /*
        3.
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        t.start();

         */

    }
}
