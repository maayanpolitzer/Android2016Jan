package com.example.hackeru.volleymovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    private ArrayList<Movie> moviesList;
    //private ListView listView;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        moviesList = new ArrayList<>();
        //listView = (ListView) findViewById(R.id.list_view);
        gridView = (GridView) findViewById(R.id.grid_view);

        String search = getIntent().getStringExtra(MainActivity.MOVIE_NAME);

        //  pointer to the singletone queue.
        RequestQueue queue = Volley.newRequestQueue(this);

        /*
        // request a String (method(GET/POST), URL, Listener for success, Listener for errors).
        StringRequest request = new StringRequest(
                Request.Method.GET,
                "http://www.walla.co.il",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Maayan", "Response: " + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Maayan", "Error:" + error);
                    }
                }
        );
        */

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                "http://www.omdbapi.com/?s=" + search + "&y=&plot=short&r=json",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray arr = response.getJSONArray("Search");
                            for (int i = 0; i < arr.length(); i++) {
                                moviesList.add(new Movie(arr.getJSONObject(i)));
                            }
                            //listView.setAdapter(new MoviesAdapter(ResultsActivity.this, moviesList));
                            gridView.setAdapter(new GridAdapter(ResultsActivity.this, moviesList));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Maayan", "Error:" + error);
                    }
                }
        );

        // add the request to the queue.
        queue.add(request);

    }
}
