package com.example.hackeru.memorygame;

import android.os.Handler;
import android.widget.ImageView;


public class FlipCardsThread extends Thread {

    ImageView clickedImage, lastImage;
    Handler handler;

    public FlipCardsThread(ImageView clickedImage, ImageView lastImage){
        this.clickedImage = clickedImage;
        this.lastImage = lastImage;
        handler = new Handler();
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                clickedImage.setImageResource(R.drawable.card_back);
                lastImage.setImageResource(R.drawable.card_back);
            }
        });

    }
}
