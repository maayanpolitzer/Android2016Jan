package com.example.hackeru.drawinggameclient.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hackeru.drawinggameclient.R;
import com.example.hackeru.drawinggameclient.infrastructure.ValidationClass;

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
            editor.putString(EMAIL, email);
            editor.putString(PASSWORD, password);
            editor.commit();
            changeActivity(MainActivity.class, null, true);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        changeActivity(LoginActivity.class, null, true);
    }



}
