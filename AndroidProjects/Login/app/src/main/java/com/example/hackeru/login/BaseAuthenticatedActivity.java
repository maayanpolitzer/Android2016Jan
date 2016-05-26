package com.example.hackeru.login;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by hackeru on 25/05/2016.
 */
public abstract class BaseAuthenticatedActivity extends BaseActivity {

    public static final String USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // check if user exists...
        String username = settings.getString(USERNAME, null);
        if (username == null){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();   // close activity
            return; // exit method...
        }
        onLoggedIn(savedInstanceState);
    }

    protected abstract void onLoggedIn(Bundle savedInstanceState);

}
