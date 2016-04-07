package com.example.hackeru.memorygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout mainLayout;
    int counter = 0;
    int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six};
    int[] shuffle = {0,1,2,3,4,5,0,1,2,3,4,5};
    ImageView lastImage;
    boolean secondCard = false;
    int turns = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        TASKS:
        1. make images random!!!
        2. if images are the same - dont flip them.
        3. at the end of the game move to doneActivity that swill show the score (turns) and will have two buttons:
            a. ReGame.
            b. quit app.
         */

        mainLayout =(LinearLayout) findViewById(R.id.main_layout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1f;

        for (int i = 0; i < 4; i++){
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            for (int j = 0; j < 3; j++){
                ImageView image = new ImageView(this);
                image.setImageResource(R.drawable.card_back);
                image.setTag(counter++);
                image.setOnClickListener(this);
                row.addView(image, params);
            }
            mainLayout.addView(row, params);
        }
    }

    @Override
    public void onClick(View v) {
        int tag = (int) v.getTag();
        //Toast.makeText(this, "You clicked " + tag, Toast.LENGTH_SHORT).show();
        ImageView clickedImage = (ImageView) v;
        clickedImage.setImageResource(images[shuffle[tag]]);
        turns++;
        if (turns % 2 == 0){
            FlipCardsThread flipThread = new FlipCardsThread(clickedImage, lastImage);
            flipThread.start();
        }
        lastImage = clickedImage;
    }
}
