package com.example.hackeru.navdrawer;

import android.support.v7.app.AppCompatActivity;

import com.example.hackeru.navdrawer.drawer.NavDrawer;

/**
 * Created by hackeru on 10/08/2016.
 */

public class BaseActivity extends AppCompatActivity {

    protected NavDrawer navDrawer;

    protected void setNavDrawer(NavDrawer navDrawer){
        this.navDrawer = navDrawer;
        this.navDrawer.create();
    }

}
