package com.example.hackeru.drawinggameclient.activities;

import android.os.Bundle;
import android.view.View;

import com.example.hackeru.drawinggameclient.R;


public class MainActivity extends BaseAuthenticatedActivity {

    @Override
    protected void onLoggedIn(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        findViewById(R.id.activity_main_start_floating_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(DrawActivity.class, null, false);
            }
        });

    }
}
