package com.example.hackeru.scrollingactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int counter;
    private LinearLayout mainLayout;
    private Button addTextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (LinearLayout) findViewById(R.id.activity_main_layout);
        addTextBtn = (Button) findViewById(R.id.activity_main_add_text_button);

        addTextBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == addTextBtn){
            TextView textView = new TextView(this);
            textView.setText("hi " + counter++);
            mainLayout.addView(textView);
        }
    }
}
