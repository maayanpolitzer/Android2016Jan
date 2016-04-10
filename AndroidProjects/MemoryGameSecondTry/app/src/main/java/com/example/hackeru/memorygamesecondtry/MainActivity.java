package com.example.hackeru.memorygamesecondtry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String SCORE = "score";
    LinearLayout mainLayout;
    int tag;
    int[] images = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
    };
    int counter;
    boolean firstTurn = true;
    ImageView previousCard = null;
    int[] shuffle = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
    int rightGuesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateShuffle();


        mainLayout = (LinearLayout) findViewById(R.id.activity_main_linear_layout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params.weight = 1f;
        for (int i = 0; i < 4; i++) {
            LinearLayout row = new LinearLayout(this);
            //row.setOrientation(LinearLayout.HORIZONTAL);
            for (int j = 0; j < 3; j++) {
                ImageView imageView = new ImageView(this);
                imageView.setTag(tag++);
                imageView.setOnClickListener(this);
                imageView.setImageResource(R.drawable.card_back);
                row.addView(imageView, params);
            }
            mainLayout.addView(row, params);
        }
    }

    private void generateShuffle() {
        Random r = new Random();
        int number;
        int random;
        for (int i = 0; i < shuffle.length; i++) {
            number = shuffle[i];
            random = r.nextInt(shuffle.length);
            shuffle[i] = shuffle[random];
            shuffle[random] = number;
        }
    }

    @Override
    public void onClick(View v) {
        ImageView clickedImage = (ImageView) v;
        if (firstTurn || (int)previousCard.getTag() != (int) clickedImage.getTag()){
            firstTurn = false;
            counter++;
            int tag = (int) v.getTag();

            clickedImage.setImageResource(images[shuffle[tag]]);
            if (counter % 2 == 0) {
                if (checkCards(clickedImage, previousCard)) {
                    // they are the same...
                    clickedImage.setOnClickListener(null);
                    previousCard.setOnClickListener(null);
                    rightGuesses++;
                    if (rightGuesses == images.length) {
                        Intent intent = new Intent(this, EndGameActivity.class);
                        intent.putExtra(SCORE, counter);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    // not the same...
                    FlipCardsThread thread = new FlipCardsThread(clickedImage, previousCard);
                    thread.start();
                }
            }
        }
        previousCard = clickedImage;
    }

    private boolean checkCards(ImageView clickedCard, ImageView previousCard) {
        return shuffle[(int) clickedCard.getTag()] == shuffle[(int) previousCard.getTag()];

    }
}
