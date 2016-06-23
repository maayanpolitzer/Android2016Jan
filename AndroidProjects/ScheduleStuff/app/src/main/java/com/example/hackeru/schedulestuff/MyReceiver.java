package com.example.hackeru.schedulestuff;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by hackeru on 22/06/2016.
 */
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MAAYAN", "called");
        Toast.makeText(context, "onReceive()", Toast.LENGTH_SHORT).show();
    }
}
