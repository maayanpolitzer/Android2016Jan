package com.example.hackeru.memorygamesecondtry;

import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by hackeru on 10/04/2016.
 */
public class FlipCardsThread extends Thread {

    ImageView clickedCard, previousCard;
    Handler handler;

    public FlipCardsThread(ImageView clickedCard, ImageView previousCard){
        this.clickedCard = clickedCard;
        this.previousCard = previousCard;
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
                clickedCard.setImageResource(R.drawable.card_back);
                previousCard.setImageResource(R.drawable.card_back);

            }
        });
    }
}
