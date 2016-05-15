package com.example.hackeru.interceptsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            SmsMessage[] messages = null;
            String message = "SMS from:";
            if (bundle != null){
                Object[] pdus = (Object[]) bundle.get("pdus");
                messages = new SmsMessage[pdus.length];
                for (int i = 0; i < messages.length; i++){
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    if (i == 0){
                        message += messages[i].getOriginatingAddress();
                        message += ":" + messages[i].getMessageBody().toString();
                    }
                }
            }
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    };
    IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MAAYAN", "onCreate();");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MAAYAN", "onResume();");

        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MAAYAN", "onPause();");

        unregisterReceiver(receiver);

    }
}
