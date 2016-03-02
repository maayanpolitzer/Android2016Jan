package com.company;

public class Main {

    private static int counter = 0;

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for( int i = 0; i < 100; i++){
                    counter++;
                }
            }
        });
        t.start();

        System.out.println("Counter is: " + counter);
    }
}
