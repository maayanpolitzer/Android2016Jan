package com.example.hackeru.schedulestuff;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    PendingIntent pendingIntent;
    Button btn;
    AlarmManager manager;
    private final int DELAY = 5000; // 5 second!!!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);

        Intent intent = new Intent(this, MyReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 4, intent, 0);
        manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);


    }

    @Override
    public void onClick(View v) {
        if (v == btn){
            //manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, DELAY, pendingIntent);
            manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, 3000, DELAY, pendingIntent);
            Log.d("MAAYAN", "started");
        }
    }

    public void cancel(View view) {
        manager.cancel(pendingIntent);
    }
}
