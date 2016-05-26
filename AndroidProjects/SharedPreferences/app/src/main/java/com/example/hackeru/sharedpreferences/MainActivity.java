package com.example.hackeru.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String COUNTER = "kevin bla bla bla";
    TextView textView;
    Button btn;
    int counter;

    SharedPreferences settings;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        editor = settings.edit();

        btn = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.textView);

        counter = settings.getInt(COUNTER, 0);

        textView.setText(counter + "");

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        counter++;
        textView.setText(counter + "");

        editor.putInt(COUNTER, counter);
        editor.commit();
    }
}
