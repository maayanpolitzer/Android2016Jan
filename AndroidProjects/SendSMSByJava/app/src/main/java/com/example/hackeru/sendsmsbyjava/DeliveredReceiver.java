package com.example.hackeru.sendsmsbyjava;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by hackeru on 15/05/2016.
 */
public class DeliveredReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int status = getResultCode();
        switch (status){
            case Activity.RESULT_OK:
                // sms delivered successfully...
                break;
            case Activity.RESULT_CANCELED:
                // Problem...
                break;
        }
    }
}
