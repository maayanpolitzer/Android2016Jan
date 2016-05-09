package com.example.hackeru.receiverlistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("TAG", "onReceive");

        Toast.makeText(context, "Maayan onReceive()", Toast.LENGTH_LONG).show();
    }
}
