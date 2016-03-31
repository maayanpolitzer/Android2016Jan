package com.example.hackeru.edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age", 18);

        TextView displayName = (TextView) findViewById(R.id.display_name);
        displayName.setText("Hello " + name);
        Toast.makeText(this, name + " is " + age + " years old",Toast.LENGTH_LONG).show();

    }
}
