package com.maayanpolitzer.firstandroidproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View view) {
        //Toast.makeText(this, "Hello, World!", Toast.LENGTH_LONG).show();
        /*
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        */
        Uri number = Uri.parse("tel:052-4455771");
        Intent intent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(intent);
    }
}
