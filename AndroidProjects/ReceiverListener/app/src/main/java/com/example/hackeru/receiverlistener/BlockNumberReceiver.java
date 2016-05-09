package com.example.hackeru.receiverlistener;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BlockNumberReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String outgoingNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        if (outgoingNumber.contains("1900")){
            setResultData(null);
        }
        Toast.makeText(context, "Block number", Toast.LENGTH_LONG).show();
    }
}
