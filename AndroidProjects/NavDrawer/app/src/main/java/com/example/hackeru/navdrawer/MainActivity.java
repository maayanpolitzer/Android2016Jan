package com.example.hackeru.navdrawer;


import android.os.Bundle;

import com.example.hackeru.navdrawer.drawer.MainNavDrawer;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        setNavDrawer(new MainNavDrawer(this));


    }
}
