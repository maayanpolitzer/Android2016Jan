package com.example.hackeru.drawinggameclient.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by hackeru on 17/08/2016.
 */
public class BaseActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "myPrefsFile";

    protected SharedPreferences settings;
    protected SharedPreferences.Editor editor;
    protected final String TOKEN = "token";
    protected final String EMAIL = "email";
    protected final String PASSWORD = "password";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editor = settings.edit();
    }

    /**
     * method to move from activity to another one.
     * @param targetActivity which activity to display
     * @param bundle data to pass to targetActivity, if null -> no data will pass
     * @param finish true will close the activity
     */
    protected void changeActivity(Class targetActivity, Bundle bundle, boolean finish){
        Intent intent = new Intent(this, targetActivity);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
        if (finish) {
            finish();
        }
    }

    public void registrationComplete(String token){

    }

    public void registrationError(String error){

    }

}
