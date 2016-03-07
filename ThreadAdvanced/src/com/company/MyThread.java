package com.company;

/**
 * Created by hackeru on 06/03/2016.
 */
public class MyThread extends Thread {

    private volatile boolean running;
    private int i;

    public MyThread(int i){
        this.i = i;
        running = true;
    }

    @Override
    public void run() {
        while(running){
            System.out.println(i);
        }
    }

    public void stopRunning(){
        running = false;
    }
}
