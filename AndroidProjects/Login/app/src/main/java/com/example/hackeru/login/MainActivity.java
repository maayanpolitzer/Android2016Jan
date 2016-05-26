package com.example.hackeru.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends BaseAuthenticatedActivity {

    TextView textView;

    @Override
    protected void onLoggedIn(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.activity_main_text_view);
    }
}
