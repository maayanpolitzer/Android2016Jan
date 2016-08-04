package com.example.hackeru.tappinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ScoreActivity extends BaseActivity {

    private TextView textView;
    private EditText nameEt;
    private Button saveBtn;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);



        textView  = (TextView) findViewById(R.id.scoreTv);
        nameEt = (EditText) findViewById(R.id.nameEt);
        saveBtn = (Button) findViewById(R.id.saveBtn);

        score = getIntent().getIntExtra(MainActivity.SCORE, -1);

        textView.setText("Your score is: " + score);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }


    private void saveData(){
        // TODO: save the name and score to the sqlite database.
        database.insert(nameEt.getText().toString().trim(), score);
        // TODO: go to WallOfFameActivity.
        Intent intent = new Intent(this, WallOfFameActivity.class);
        startActivity(intent);
    }

}
