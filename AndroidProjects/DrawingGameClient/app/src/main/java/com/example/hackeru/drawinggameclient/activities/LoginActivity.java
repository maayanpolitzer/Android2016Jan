package com.example.hackeru.drawinggameclient.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hackeru.drawinggameclient.R;
import com.example.hackeru.drawinggameclient.infrastructure.ValidationClass;
import com.example.hackeru.drawinggameclient.threads.BaseThread;
import com.example.hackeru.drawinggameclient.threads.SendEmailAndPasswordThread;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.activity_login_register_text_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(RegisterActivity.class, null, true);
            }
        });

    }

    public void login(View view) {
        String email = ((EditText) findViewById(R.id.activity_login_email_edit_text)).getText().toString();
        String password = ((EditText) findViewById(R.id.activity_login_password_edit_text)).getText().toString();
        if(ValidationClass.validate(email, password)){
            new SendEmailAndPasswordThread(email, password, this, BaseThread.ACTION_LOGIN).start();
        }
    }

    @Override
    public void registrationComplete(String token) {
        editor.putString(TOKEN, token);
        editor.commit();
        changeActivity(MainActivity.class, null, true);
    }

    @Override
    public void registrationError(String error) {
        Toast.makeText(this, "Error: " + error, Toast.LENGTH_LONG).show();
    }
}
