package com.example.hackeru.sendsmsbyjava;

import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
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

    private static final int PICK_CONTACT_REQUEST_CODE = 1;
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
            Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
            startActivityForResult(intent, PICK_CONTACT_REQUEST_CODE);
        }else if(v == sendMessageBtn){
            // send message...
            String tel = telNumberEditText.getText().toString();
            String message = messageEditText.getText().toString();

            messages.add(tel + ":" + message);
            adapter.notifyDataSetChanged();
            messageEditText.setText("");


            /*  code to send a real SMS - won't work on emulator...
            SmsManager manager = SmsManager.getDefault();
            PendingIntent sentPendingIntent = PendingIntent.getBroadcast(this, 1, new Intent("SMS_SENT"), 0);
            PendingIntent deliveredPendingIntent = PendingIntent.getBroadcast(this, 2, new Intent("SMS_DELIVERED"), 0);
            manager.sendTextMessage(tel, null, message, sentPendingIntent, deliveredPendingIntent);
            */
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_CONTACT_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                Uri uri = data.getData();
                String phoneNumber = getContactNumberByUri(uri);
                telNumberEditText.setText(phoneNumber);
            }else{
                //   clicked on back button...
            }
        }
    }

    private String getContactNumberByUri(Uri uri){
        String phoneNumber = null;
        ContentResolver nataliResolver = getContentResolver();
        Cursor cursor = nataliResolver.query(uri, null, null, null, null);
        if (cursor.moveToFirst()){
            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            //Toast.makeText(this, "The id of maayan: " + id, Toast.LENGTH_LONG).show();

            Cursor getNumberCursor = nataliResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id}, null);
            while (getNumberCursor.moveToNext()){
                phoneNumber = getNumberCursor.getString(getNumberCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
         //       Toast.makeText(this, "number is: " + phoneNumber, Toast.LENGTH_LONG).show();
            }
        }else{
            phoneNumber = "No such contact...";
        }

        return phoneNumber;
    }

}
