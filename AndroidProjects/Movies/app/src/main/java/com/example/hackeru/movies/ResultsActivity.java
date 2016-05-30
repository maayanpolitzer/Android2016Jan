package com.example.hackeru.movies;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String MOVIE_ID = "id";
    private ListView listView;
    private MoviesAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String movie = getIntent().getStringExtra(MainActivity.MOVIE);
        String search = "http://www.omdbapi.com/?s=" + movie + "&y=&plot=short&r=json";

        listView = (ListView) findViewById(R.id.list_view);
        listView.setOnItemClickListener(this);

        new DownloadJsonTask().execute(search);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, MovieActivity.class);
        intent.putExtra(MOVIE_ID, movies.get(position).getId());
        startActivity(intent);
    }

    private class DownloadJsonTask extends AsyncTask<String, Void, ArrayList<Movie>> {

        @Override
        protected ArrayList<Movie> doInBackground(String... params) {
            ArrayList<Movie> tempMovies = new ArrayList<>();
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream in = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null){
                    sb.append(line);
                }
                //Log.d("Maayan", sb.toString());
                try {
                    JSONObject mainObject = new JSONObject(sb.toString());
                    JSONArray jsonArray = mainObject.getJSONArray("Search");
                    for (int i = 0; i < jsonArray.length(); i++){
                        //Log.d("Maayan", jsonArray.get(i).toString());
                        tempMovies.add(new Movie(jsonArray.getJSONObject(i)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return tempMovies;
        }

        @Override
        protected void onPostExecute(ArrayList<Movie> strings) {
            movies = strings;
            adapter = new MoviesAdapter(ResultsActivity.this, movies, new Handler());
            listView.setAdapter(adapter);
        }
    }

}
