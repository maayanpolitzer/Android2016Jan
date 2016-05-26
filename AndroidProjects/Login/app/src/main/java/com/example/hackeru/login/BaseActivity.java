package com.example.hackeru.login;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hackeru on 25/05/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected SharedPreferences settings;
    protected SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settings = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        editor = settings.edit();

    }
}
