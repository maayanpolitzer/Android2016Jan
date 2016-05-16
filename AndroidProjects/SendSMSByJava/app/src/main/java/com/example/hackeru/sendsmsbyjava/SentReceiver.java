package com.example.hackeru.sendsmsbyjava;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;

/**
 * Created by hackeru on 15/05/2016.
 */
public class SentReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int status = getResultCode();
        switch (status){
            case Activity.RESULT_OK:
                // SMS sent successfully...
                Log.d("Maayan", "Sms sent!!!");
                break;
            case SmsManager.RESULT_ERROR_NO_SERVICE:
                // no reception...
                break;
            case SmsManager.RESULT_ERROR_NULL_PDU:
                // not valid number;
                break;
            case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                //problem...
                break;
            case SmsManager.RESULT_ERROR_RADIO_OFF:
                // radio off...
                break;
        }
    }
}
