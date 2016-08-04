package com.example.hackeru.tappinggame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hackeru on 03/08/2016.
 */
public class BaseActivity extends AppCompatActivity {

    protected DataSource database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = new DataSource(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        database.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        database.close();
    }
}
