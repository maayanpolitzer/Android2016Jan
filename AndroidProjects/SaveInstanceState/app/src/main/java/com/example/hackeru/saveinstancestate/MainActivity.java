package com.example.hackeru.saveinstancestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String COUNTER = "counter";
    TextView textView;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.counter);

        if (savedInstanceState != null){
            counter = savedInstanceState.getInt(COUNTER);
            textView.setText("counter is: " + counter);
        }
        
    }

    public void increment(View view) {
        textView.setText("counter is: " + ++counter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(COUNTER, counter);
    }

}
