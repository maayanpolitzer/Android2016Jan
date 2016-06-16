package com.example.hackeru.startactivityforresults;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void bvack(View view) {
        EditText et = (EditText) findViewById(R.id.et);
        String name = et.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("name", name);
        setResult(190, intent);
        finish();
    }
}
