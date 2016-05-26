package com.example.hackeru.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    EditText username, password;
    Button loginBtn, signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.activity_login_username_edit_text);
        password = (EditText) findViewById(R.id.activity_login_password_edit_text);

        loginBtn = (Button) findViewById(R.id.activity_login_login_button);
        signupBtn = (Button) findViewById(R.id.activity_login_signup_button);

        loginBtn.setOnClickListener(this);
        signupBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == loginBtn){
            // login...
            editor.putString(BaseAuthenticatedActivity.USERNAME, "maayan");
            editor.commit();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            // signup...

        }
    }
}
