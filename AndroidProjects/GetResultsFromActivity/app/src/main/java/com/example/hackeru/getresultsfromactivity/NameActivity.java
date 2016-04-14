package com.example.hackeru.getresultsfromactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by hackeru on 13/04/2016.
 */
public class NameActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameEditText;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        nameEditText = (EditText) findViewById(R.id.activity_name_name_edit_text);
        backBtn = (Button) findViewById(R.id.activity_name_back_button);
        backBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("Name", nameEditText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}

