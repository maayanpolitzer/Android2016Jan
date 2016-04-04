package com.example.hackeru.tipcaculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TipActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tipTv;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        tipTv = (TextView) findViewById(R.id.activity_tip_tip_text_view);
        backBtn = (Button) findViewById(R.id.activity_tip_back_button);
        backBtn.setOnClickListener(this);

        double tip = getIntent().getDoubleExtra(MainActivity.TIP, 0);

        tipTv.setText("The tip is: " + tip);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
