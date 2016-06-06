package com.example.hackeru.volleymovies;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

/**
 * Created by hackeru on 05/06/2016.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    private Context context;
    private ArrayList<Movie> movies;
    public static final String IMAGE = "image";

    public MoviesAdapter(Context context, ArrayList<Movie> movies){
        super(context, R.layout.list_item, movies);
        this.context = context;
        this.movies = movies;
    }

    private static class ViewHolder {
        ImageView poster;
        TextView title;
        TextView year;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null, false);
            viewHolder.poster = (ImageView) convertView.findViewById(R.id.list_item_poster);
            viewHolder.title = (TextView) convertView.findViewById(R.id.list_item_title);
            viewHolder.year = (TextView) convertView.findViewById(R.id.list_item_year);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        getImage(viewHolder.poster, movies.get(position).getPoster());
        viewHolder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PosterDialog dialog = new PosterDialog();       // create dialog object.
                FragmentManager manager = ((Activity) context).getFragmentManager();    // getFragmentManager.
                dialog.setImage(((ImageView) v).getDrawable());     // send image to dialog...
                dialog.show(manager, "POSTER");

            }
        });
        viewHolder.title.setText(movies.get(position).getTitle());
        viewHolder.year.setText(movies.get(position).getYear());

        return convertView;
    }

    private void getImage(final ImageView poster, String url){

        RequestQueue queue = Volley.newRequestQueue(context);

        ImageRequest request = new ImageRequest(
                url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        poster.setImageBitmap(response);
                    }
                },
                0,
                0,
                null,
                null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Maayan", "Error: " + error);
                        // set dummy image...
                    }
                }
        );

        queue.add(request);

    }
}
