package com.example.hackeru.tappinggame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    static final String SCORE = "score";
    private Button btn;
    private int counter;
    private boolean playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.startBtn);

        btn.setOnClickListener(startGameListener);

    }

    private View.OnClickListener startGameListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!playing) {
                playing = true;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        playing = false;
                        gameEnd();
                    }
                }).start();
            }
        }
    };

    private void gameEnd(){
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra(SCORE, counter);
        startActivity(intent);


    }

    public void update(View view){
        database.update(2, 150);
        Intent intent = new Intent(this, WallOfFameActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (playing && event.getAction() == MotionEvent.ACTION_DOWN){
            counter++;
        }
        return super.onTouchEvent(event);
    }
}
