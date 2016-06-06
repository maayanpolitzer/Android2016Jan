package com.example.hackeru.volleymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String MOVIE_NAME = "movie";
    private EditText editText;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.activity_main_search_edit_text);
        btn = (Button) findViewById(R.id.activity_main_button);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,ResultsActivity.class);
        intent.putExtra(MOVIE_NAME, editText.getText().toString());
        startActivity(intent);
    }
}
