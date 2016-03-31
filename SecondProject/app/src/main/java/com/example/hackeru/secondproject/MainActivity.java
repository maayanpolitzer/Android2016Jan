package com.example.hackeru.secondproject;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicked(View view) {
        //Toast.makeText(this, "you clicked the button",Toast.LENGTH_SHORT).show();
        /*
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
        */
        /*
        Uri uri = Uri.parse("http://www.aliexpress.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        */
        /*
        Uri contacts = Uri.parse("content://contacts");
        Intent intent = new Intent(Intent.ACTION_PICK, contacts);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivity(intent);
        */
    }
}
