package com.company;

/**
 * Created by hackeru on 20/03/2016.
 */
public class TranslateThread extends Thread{

    private ChangeDisplayListener listener;
    private volatile boolean isWorking;

    public TranslateThread(ChangeDisplayListener listener){
        this.listener = listener;
        isWorking = true;
    }

    @Override
    public void run() {
        while(isWorking){
            listener.changeDisplay();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setWorking(boolean status){
        isWorking = status;
    }

}
