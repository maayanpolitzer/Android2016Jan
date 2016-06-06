package com.example.hackeru.volleymovies;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hackeru on 05/06/2016.
 */
public class Movie {

    private String title, year, poster, id;

    public Movie(JSONObject obj){
        try {
            title = obj.getString("Title");
            year = obj.getString("Year");
            poster = obj.getString("Poster");
            id = obj.getString("imdbID");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return title + ", " + year;
    }

    public String getTitle() {
        return title;
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
