package com.example.hackeru.moviessearchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String SEARCH = "fgjndflbndflbn";
    EditText searchEditText;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = (EditText) findViewById(R.id.activity_main_search_edit_text);
        searchButton = (Button) findViewById(R.id.activity_main_search_button);

        searchButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String movieSearch = searchEditText.getText().toString().trim();
        if(!movieSearch.isEmpty()){
            Intent intent  = new Intent(this, ResultsActivity.class);
            intent.putExtra(SEARCH, movieSearch);
            startActivity(intent);
        }else{
            searchEditText.setError("Cannot stay empty...");
        }
    }
}
