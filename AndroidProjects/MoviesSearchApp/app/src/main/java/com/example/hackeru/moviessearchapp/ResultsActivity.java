package com.example.hackeru.moviessearchapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    private ArrayList<Movie> moviesList;
    private ListView listView;
    private MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        listView = (ListView) findViewById(R.id.activity_results_list_view);

        String search = getIntent().getStringExtra(MainActivity.SEARCH);

        sendRequest("http://www.omdbapi.com/?r=json&page=1&s=spy");

    }

    private void sendRequest(String movieSearch){
        new GetAllMoviesTask().execute(movieSearch);
    }

    private void convertStringToList(String movies){
        moviesList = new ArrayList<>();
        // TODO: convert to jsonArray -> convert each jsonObject to movie object - > add movie to moviesList.
        //MoviesAdapter adapter = new MoviesAdapter(moviesList);    // TODO: add moviesList to contructor.
        //listView.setAdapter(adapter);
    }

    private class GetAllMoviesTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {
            // TODO: send real request and get the response String.
            StringBuilder sb = new StringBuilder();
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = null;
                while ((line = reader.readLine()) != null){
                    sb.append(line);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return sb.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            convertStringToList(s);
        }
    }


}
