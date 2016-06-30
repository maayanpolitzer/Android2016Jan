package com.example.hackeru.notifications;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String name = getIntent().getStringExtra("NAME");

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(34534);

        TextView tv = new TextView(this);
        tv.setText("Your name is: " + name);
        setContentView(tv);
    }
}
