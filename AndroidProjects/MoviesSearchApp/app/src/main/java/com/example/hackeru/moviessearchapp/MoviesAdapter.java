package com.example.hackeru.moviessearchapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hackeru on 25/05/2016.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    ImageView imageView;

    public MoviesAdapter(Context context, ArrayList<Movie> moviesList){
        super(context, R.layout.list_item, moviesList);
    }


    private class ViewHolder{

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        // check convertView.
        if (convertView == null){
            // TODO: create viewHolder object.
            // TODO: inflate list_item.xml to convertView.
            // TODO: get convertView reference with viewHolder.
            // TODO: set tag.
        }else{
            //TODO:get tag.
        }
        // TODO: insert data from list by position.
        //new DownloadImageTask().execute(moviesList.get(position).getPoster());
        return convertView;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                InputStream in = con.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                return bitmap;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap == null){
                // TODO: display resource image "NO IMAGE";
            }else{
                imageView.setImageBitmap(bitmap);
            }
        }
    }

}
