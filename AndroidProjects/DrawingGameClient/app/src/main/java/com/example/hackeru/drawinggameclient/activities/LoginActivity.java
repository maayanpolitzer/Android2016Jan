package com.example.hackeru.drawinggameclient.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hackeru.drawinggameclient.R;
import com.example.hackeru.drawinggameclient.infrastructure.ValidationClass;

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
            editor.putString(EMAIL, email);
            editor.putString(PASSWORD, password);
            editor.commit();
            /*
        TODO:
        2. send data to server.
        3. get the boolean from server.
        5. if true -> start MainActivity.
         */
            changeActivity(MainActivity.class, null, true);
        }
    }
}
