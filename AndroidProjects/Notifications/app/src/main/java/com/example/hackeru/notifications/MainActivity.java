package com.example.hackeru.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button createBtn,cancelBtn;
    private int counter;
    BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(34534);

        createBtn = (Button) findViewById(R.id.createBtn);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);

        createBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);

       receiver = new BroadcastReceiver() {
           @Override
           public void onReceive(Context context, Intent intent) {
               NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
               manager.cancel(34534);
               finish();
           }
       };

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter("closeTheApp");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @Override
    public void onClick(View v) {
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (v == createBtn){
            // create notification...
            Notification notification = createNotification();
            manager.notify(34534, notification);
            // display the notification.
        }else {
            // cancel notification...
            manager.cancel(34534);
        }
    }

    private Notification createNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setContentTitle("This is the title");

        builder.setContentText("dfdf1");
        builder.setOngoing(true);
        //builder.setSound()
        builder.setSubText("dfdfdf2");  // one more line...
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("NAME", "maayan");
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pi);
        builder.setSmallIcon(android.R.drawable.ic_menu_agenda);
        Intent intent2 = new Intent(this, MainActivity.class);
        PendingIntent actionPi = PendingIntent.getActivity(this, 0, intent2, 0);
        builder.addAction(android.R.drawable.ic_btn_speak_now, "shut down", actionPi);
        Intent closeIntent = new Intent("closeTheApp");
        PendingIntent closePi = PendingIntent.getBroadcast(this, 0, closeIntent, 0);
        builder.addAction(R.mipmap.ic_launcher, "close", closePi);
        return builder.build();
    }

}
