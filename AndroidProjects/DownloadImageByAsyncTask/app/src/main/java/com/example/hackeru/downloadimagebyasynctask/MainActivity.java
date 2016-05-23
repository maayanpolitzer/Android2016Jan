package com.example.hackeru.downloadimagebyasynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button downloadBtn;
    ImageView imageView;
    ProgressBar progressBar;

    String imageUrl = "https://www.sunnymaldives.com/images/uploads/rooms/bed-room-2-haven-water-villas-paradise-island-resort-and-spa-maldives-5-star-island-hotel-north-male-atoll.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadBtn = (Button) findViewById(R.id.downloadBtn);
        imageView = (ImageView) findViewById(R.id.imageView);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        downloadBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        new DownloadTask().execute(imageUrl);
    }

    private class DownloadTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
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
            // hide the progressbar, display the image...
            progressBar.setVisibility(View.INVISIBLE);
            if (bitmap != null){
                imageView.setImageBitmap(bitmap);
            }
        }
    }

}
