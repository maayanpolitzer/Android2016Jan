package com.example.hackeru.movies;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hackeru on 29/05/2016.
 */
public class Movie {

    private String name;
    private String year;
    private String poster;
    private String id;

    public Movie(JSONObject obj){
        try {
            name = obj.getString("Title");
            year = obj.getString("Year");
            id = obj.getString("imdbID");
            poster = obj.getString("Poster");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getPoster() {
        return poster;
    }

    public String getId() {
        return id;
    }
}
