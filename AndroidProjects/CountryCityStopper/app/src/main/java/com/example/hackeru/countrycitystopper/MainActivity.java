package com.example.hackeru.countrycitystopper;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ChangeLetterListener {

    TextView tv;
    Button btn;
    boolean working = false;
    MyOtherThread t;

    //Other way...
    String[] letters = {"א", "ב", "ג", "ד", "ה", "ו", "ז", "ח", "ט", "י", "כ",
            "ל", "מ", "נ", "ס", "ע", "פ", "צ", "ק", "ר", "ש", "ת"};
    int counter = 0;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        handler = new Handler();

    }

    @Override
    public void onClick(View v) {
        if (!working){
            // start working...
            btn.setText("STOP");
            t = new MyOtherThread(this);
            t.start();
        }else{
            // stop working...
            btn.setText("START");
            t.stopRunning();
        }
        working = !working;

        /*
        switch(v.getId()){
            case R.id.tv:

                break;
            case R.id.btn:

                break;
            default:

                break;
        }
        */
        /*
        if (v == tv){

        }else if(v == btn){

        }else{
            Toast.makeText(this, "WHAT????", Toast.LENGTH_SHORT).show();
        }
        */
    }

    @Override
    public void changeLetter() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                tv.setText(letters[counter++]);
                if (counter == letters.length){
                    counter = 0;
                }
            }
        });
    }
}
