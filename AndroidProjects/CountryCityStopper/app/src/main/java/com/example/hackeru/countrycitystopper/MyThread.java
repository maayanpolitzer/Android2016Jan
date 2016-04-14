package com.example.hackeru.countrycitystopper;

import android.os.Handler;
import android.widget.TextView;

/**
 * Created by hackeru on 13/04/2016.
 */
public class MyThread extends Thread {

    TextView tv;
    Handler handler;
    private volatile boolean working;
    String[] letters = {"א", "ב", "ג", "ד", "ה", "ו", "ז", "ח", "ט", "י", "כ",
            "ל", "מ", "נ", "ס", "ע", "פ", "צ", "ק", "ר", "ש", "ת"};
    int counter = 0;


    public MyThread(TextView tv){
        this.tv = tv;
        working = true;
        handler = new Handler();
    }

    @Override
    public void run() {
        while(working){
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    tv.setText(letters[counter++]);
                    if (counter == letters.length){
                        counter = 0;
                    }
                }
            });
        }

    }

    public void stopRunning(){
        working = false;
    }
}
