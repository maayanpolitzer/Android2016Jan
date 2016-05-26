package com.example.hackeru.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends BaseActivity implements View.OnClickListener {

    EditText username, password, confirmPassword;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.activity_sign_up_username_edit_text);
        password = (EditText) findViewById(R.id.activity_sign_up_password_edit_text);
        confirmPassword = (EditText) findViewById(R.id.activity_sign_up_confirm_password_edit_text);

        btn = (Button) findViewById(R.id.activity_sign_up_btn);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
