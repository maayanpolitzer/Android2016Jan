package com.example.hackeru.movies;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hackeru on 29/05/2016.
 */
public class DownloadThread extends Thread {

    private ImageView imageView;
    private String link;
    private Handler handler;

    public DownloadThread(ImageView imageView, String link, Handler handler){
        Log.d("Maayan", "STATRT");
        this.imageView = imageView;
        this.link = link;
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            final Bitmap bitmap = BitmapFactory.decodeStream(in);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageBitmap(bitmap);
                    Log.d("Maayan", "END");
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
