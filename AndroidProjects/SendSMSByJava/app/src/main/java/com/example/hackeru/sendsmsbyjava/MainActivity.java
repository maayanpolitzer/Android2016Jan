package com.example.hackeru.sendsmsbyjava;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText telNumberEditText;
    private EditText messageEditText;
    private Button addContactBtn;
    private Button sendMessageBtn;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telNumberEditText = (EditText) findViewById(R.id.activity_main_tel_edit_text);
        messageEditText = (EditText) findViewById(R.id.activity_main_message_edit_text);
        addContactBtn = (Button) findViewById(R.id.activity_main_contact_btn);
        sendMessageBtn = (Button) findViewById(R.id.activity_main_send_message_btn);
        listView = (ListView) findViewById(R.id.activity_main_list_view);

        messages = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, messages);
        listView.setAdapter(adapter);

        addContactBtn.setOnClickListener(this);
        sendMessageBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == addContactBtn){
            // get contact by intent...

        }else if(v == sendMessageBtn){
            // send message...
            String tel = telNumberEditText.getText().toString();
            String message = messageEditText.getText().toString();
            //Toast.makeText(this, "Tel: " + tel + ", message: " + message, Toast.LENGTH_LONG).show();
            /*
            messages.add(message);
            adapter.notifyDataSetChanged();
            messageEditText.setText("");
            */


            SmsManager manager = SmsManager.getDefault();
            PendingIntent sentPendingIntent = PendingIntent.getBroadcast(this, 1, new Intent("SMS_SENT"), 0);
            PendingIntent deliveredPendingIntent = PendingIntent.getBroadcast(this, 2, new Intent("SMS_DELIVERED"), 0);
            manager.sendTextMessage(tel, null, message, sentPendingIntent, deliveredPendingIntent);

        }
    }
}
