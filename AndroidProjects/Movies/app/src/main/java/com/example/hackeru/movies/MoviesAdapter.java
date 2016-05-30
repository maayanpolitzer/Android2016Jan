package com.example.hackeru.movies;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by hackeru on 29/05/2016.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    private Context context;
    private ArrayList<Movie> movies;
    private Handler handler;

    public MoviesAdapter(Context context, ArrayList<Movie> movies, Handler handler){
        super(context, R.layout.list_item, movies);
        this.context = context;
        this.movies = movies;
        this.handler = handler;
    }

    private class ViewHolder {
        ImageView posterImageView;
        TextView titleTextView;
        TextView yearTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null, false);
            viewHolder.posterImageView = (ImageView) convertView.findViewById(R.id.list_item_poster);
            viewHolder.titleTextView = (TextView) convertView.findViewById(R.id.list_item_title);
            viewHolder.yearTextView = (TextView) convertView.findViewById(R.id.list_item_year);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //new DownloadImageTask(viewHolder.posterImageView).execute(movies.get(position).getPoster());
        new DownloadThread(viewHolder.posterImageView, movies.get(position).getPoster(), handler).start();
        viewHolder.titleTextView.setText(movies.get(position).getName());
        viewHolder.yearTextView.setText(movies.get(position).getYear());
        return convertView;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        private ImageView imageView;

        public DownloadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Log.d("Maayan", "START");
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream in = connection.getInputStream();
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
            if (bitmap != null){
                imageView.setImageBitmap(bitmap);
                Log.d("Maayan", "END");
            }
        }
    }

}
