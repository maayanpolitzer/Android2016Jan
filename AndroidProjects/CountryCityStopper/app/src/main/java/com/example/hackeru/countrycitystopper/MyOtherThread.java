package com.example.hackeru.countrycitystopper;

/**
 * Created by hackeru on 13/04/2016.
 */
public class MyOtherThread extends Thread {

    ChangeLetterListener listener;
    private volatile boolean working;

    public MyOtherThread(ChangeLetterListener listener){
        this.listener = listener;
        working = true;
    }

    @Override
    public void run() {
        while(working){
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listener.changeLetter();
        }
    }

    public void stopRunning(){
        working = false;
    }
}
