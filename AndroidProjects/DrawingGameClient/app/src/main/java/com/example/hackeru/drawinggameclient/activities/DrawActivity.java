package com.example.hackeru.drawinggameclient.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hackeru.drawinggameclient.R;
import com.example.hackeru.drawinggameclient.custom_views.DrawingLayout;

public class DrawActivity extends BaseAuthenticatedActivity {


    @Override
    protected void onLoggedIn(Bundle savedInstanceState) {
        DrawingLayout layout = new DrawingLayout(this);
        setContentView(layout);

    }
}
