package com.example.hackeru.drawinggameclient.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hackeru.drawinggameclient.R;
import com.example.hackeru.drawinggameclient.infrastructure.ValidationClass;
import com.example.hackeru.drawinggameclient.threads.BaseThread;
import com.example.hackeru.drawinggameclient.threads.SendEmailAndPasswordThread;

public class RegisterActivity extends BaseActivity {

    private EditText emailET, passwordET, conPasswordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailET = (EditText) findViewById(R.id.activity_register_email_edit_text);
        passwordET = (EditText) findViewById(R.id.activity_register_password_edit_text);
        conPasswordET = (EditText) findViewById(R.id.activity_register_confirm_password_edit_text);

    }

    public void signup(View view) {
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();
        String conPassword = conPasswordET.getText().toString();
        if (ValidationClass.validate(email,password,conPassword)){
            /*
            TODO:
            1. send data to server.
            2. get boolean back.
            3. save data in shared prefrences.
            4. if true -> send to MainActivity.
             */
            new SendEmailAndPasswordThread(email, password, this, BaseThread.ACTION_REGISTER).start();

        }

    }

    @Override
    public void registrationComplete(String token){
        Log.d("TAG", "complete: " + token);
        editor.putString(TOKEN, token);
        editor.commit();
        changeActivity(MainActivity.class, null, true);
    }

    @Override
    public void registrationError(String error){
        Log.d("TAG", "error");
        Toast.makeText(this, "Error: " + error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        changeActivity(LoginActivity.class, null, true);
    }



}
