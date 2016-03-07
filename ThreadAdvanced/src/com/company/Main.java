package com.company;

public class Main {

    int counter = 0;

    public static void main(String[] args) {

        /*
        MyThread m = new MyThread(5);
        m.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m.stopRunning();
        */
        Main moshe = new Main();
        moshe.work();
        System.out.println("done");

    }

    public void work(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++){
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++){
                    increment();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.println("join done");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("counter is: " + counter);
    }

    private synchronized void increment(){
        counter++;
    }

}
