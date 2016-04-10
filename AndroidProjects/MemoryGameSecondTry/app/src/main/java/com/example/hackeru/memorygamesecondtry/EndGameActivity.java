package com.example.hackeru.memorygamesecondtry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        int score = getIntent().getIntExtra(MainActivity.SCORE, -1);

        TextView scoreTextView = (TextView) findViewById(R.id.activity_end_game_score_text_view);
        scoreTextView.setText("Your score is: " + score);
    }

    public void rematch(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void goodbye(View view) {
        finish();
    }
}
