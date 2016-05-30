package com.example.hackeru.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String MOVIE = "kevin";
    private EditText search;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = (EditText) findViewById(R.id.search_edit_text);
        btn = (Button) findViewById(R.id.search_button);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String movie = search.getText().toString().trim();
        if(!movie.isEmpty()){
            Intent intent = new Intent(this, ResultsActivity.class);
            intent.putExtra(MOVIE, movie);
            startActivity(intent);
        }else{
            search.setError("Can't stay empty...");
        }
    }
}
