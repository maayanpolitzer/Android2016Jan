package com.example.hackeru.navdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hackeru.navdrawer.drawer.MainNavDrawer;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setNavDrawer(new MainNavDrawer(this));
    }
}
